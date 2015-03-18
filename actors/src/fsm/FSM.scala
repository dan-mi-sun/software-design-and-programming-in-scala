package fsm

import akka.actor.{Actor, FSM}

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

