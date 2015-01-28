package algebraic

// if Vehicle is a Bike or Car

sealed trait Vehicle
final case class Bike() extends Vehicle
final case class Car() extends Vehicle


// =========================== Is-a OR pattern SUM type

/*
        AND               OR
IS-A    Cake              Sum type
HAS-A   Product type      ???
*/

// Huly is a Fly and Human

trait Human
trait Fly
trait Huly extends Human with Fly // with xxx

// Cake Pattern

// "has-a or" pattern
// Person has a RealHand or ArtificialLimb
// Person has a h of type Hand, where Hand is RealHand or ArtificialLimb

trait Person {
  def h: Hand
}

sealed trait Hand
final case class RealHand() extends Hand
final case class ArtificialLimb() extends Hand
