package fsm

// FSM states

sealed trait FSMHakkerState

case object Waiting extends FSMHakkerState

case object Thinking extends FSMHakkerState

case object Hungry extends FSMHakkerState

case object WaitForOtherChopstick extends FSMHakkerState

case object FirstChopstickDenied extends FSMHakkerState

case object Eating extends FSMHakkerState