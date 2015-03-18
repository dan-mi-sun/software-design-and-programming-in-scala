package fsm

import akka.actor.ActorRef

// States

sealed trait ChopstickState

case object CSAvailabe extends ChopstickState

case object CSTaken extends ChopstickState

case class IsWith(hakker: ActorRef)

