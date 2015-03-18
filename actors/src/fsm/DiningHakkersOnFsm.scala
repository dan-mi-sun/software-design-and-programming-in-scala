package fsm

import akka.actor._

import scala.concurrent.duration._

// Messages

sealed trait ChopstickMessage

object CmsgGrab extends ChopstickMessage

object CmsgRetn extends ChopstickMessage

case class CmsgTaken(chopstick: ActorRef) extends ChopstickMessage

case class CmsgBusy(chopstick: ActorRef) extends ChopstickMessage


// States

sealed trait ChopstickState

case object CSAvailabe extends ChopstickState

case object CSTaken extends ChopstickState

case class IsWith(hakker: ActorRef)

// FSM

class Chopstick extends Actor with FSM[ChopstickState, IsWith] {

  import context._

  startWith(CSAvailabe, IsWith(system.deadLetters))

  when(CSAvailabe) {
    case Event(CmsgGrab, _) =>
      goto(CSTaken) using IsWith(sender) replying CmsgTaken(self)
  }

  when(CSTaken) {
    case Event(CmsgGrab, currentState) =>
      stay replying CmsgBusy(self)
    case Event(CmsgRetn, IsWith(hakker)) if sender == hakker =>
      goto(CSAvailabe) using IsWith(system.deadLetters)
  }

  initialize
}

// FSM messages

sealed trait FSMHakkerMessage

object Think extends FSMHakkerMessage

// FSM states

sealed trait FSMHakkerState

case object Waiting extends FSMHakkerState

case object Thinking extends FSMHakkerState

case object Hungry extends FSMHakkerState

case object WaitForOtherChopstick extends FSMHakkerState

case object FirstChopstickDenied extends FSMHakkerState

case object Eating extends FSMHakkerState

// --------------

case class Possess(left: Option[ActorRef], right: Option[ActorRef])

class FSMHakker(name: String, left: ActorRef, right: ActorRef)
  extends Actor with FSM[FSMHakkerState, Possess] {

  startWith(Waiting, Possess(None, None))

  when(Waiting) {
    case Event(Think, _) =>
      println(s"$name starts to think")
      startThinking(5.seconds)
  }

  when(Thinking) {
    case Event(StateTimeout, _) =>
      left ! CmsgGrab
      right ! CmsgGrab
      goto(Hungry)
  }

  when(Hungry) {
    case Event(CmsgTaken(`left`), _) =>
      goto(WaitForOtherChopstick) using Possess(Some(left), None)
    case Event(CmsgTaken(`right`), _) =>
      goto(WaitForOtherChopstick) using Possess(None, Some(right))
    case Event(CmsgBusy(_), _) =>
      goto(FirstChopstickDenied)
  }

  when(WaitForOtherChopstick) {
    case Event(CmsgTaken(`left`), Possess(None, Some(right))) =>
      startEating(left, right)
    case Event(CmsgTaken(`right`), Possess(Some(left), None)) =>
      startEating(left, right)
    case Event(CmsgBusy(chopstick), Possess(leftOption, rightOption)) =>
      leftOption.foreach(_ ! CmsgRetn)
      rightOption.foreach(_ ! CmsgRetn)
      startThinking(10.milliseconds)
  }

  private def startEating(left: ActorRef, right: ActorRef) = {
    println(s"$name has picked up ${left.path.name} and ${right.path.name} and starts to eat")
    goto(Eating) using
      Possess(Some(left), Some(right)) forMax (5.seconds)
  }

  when(FirstChopstickDenied) {
    case Event(CmsgTaken(secondChopstick), _) =>
      secondChopstick ! CmsgRetn
      startThinking(10.milliseconds)
    case Event(CmsgBusy(chopstick), _) =>
      startThinking(10.milliseconds)
  }

  when(Eating) {
    case Event(StateTimeout, _) =>
      println(s"$name puts chopsticks down and starts to think")
      left ! CmsgRetn
      right ! CmsgRetn
      startThinking(5.seconds)
  }

  initialize

  private def startThinking(duration: FiniteDuration): State = {
    goto(Thinking) using
      Possess(None, None) forMax duration
  }
}

object DiningHakkersOnFsm extends App {

  val acsy = ActorSystem()
  val chopsticks =
    for (i <- 0 to 4) yield
      acsy.actorOf(Props[Chopstick], "C" + i)
  val hakkers = for {
    (name, i) <- List("P0", "P1", "P2", "P3", "P4").zipWithIndex
  } yield
    acsy.actorOf(
      Props(classOf[FSMHakker],
        name, chopsticks(i), chopsticks((i + 1) % 5)))
  hakkers.foreach(_ ! Think)
}