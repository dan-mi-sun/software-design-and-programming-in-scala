package fsm

import akka.actor.{Actor, ActorRef, FSM}

import scala.concurrent.duration.FiniteDuration
import scala.concurrent.duration._

case class Possess(left: Option[ActorRef], right: Option[ActorRef])

class FSMHakker(name: String, left: ActorRef, right: ActorRef)
  extends Actor with FSM[FSMHakkerState, Possess] {

  startWith(Waiting, Possess(None, None))

  when(Waiting) {
    case Event(Think, _) =>
      println(s"$name starts to think")
      startThinking(5 seconds)
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
      Possess(Some(left), Some(right)) forMax (5 seconds)
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