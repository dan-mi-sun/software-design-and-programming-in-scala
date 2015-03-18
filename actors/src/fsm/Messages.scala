package fsm

import akka.actor.ActorRef

// Messages

sealed trait ChopstickMessage

object CmsgGrab extends ChopstickMessage

object CmsgRetn extends ChopstickMessage

case class CmsgTaken(chopstick: ActorRef) extends ChopstickMessage

case class CmsgBusy(chopstick: ActorRef) extends ChopstickMessage
