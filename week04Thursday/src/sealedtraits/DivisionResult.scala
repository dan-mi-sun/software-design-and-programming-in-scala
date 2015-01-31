package sealedtraits

sealed trait DivisionResult

final case class Finite(value: Int) extends DivisionResult

case object Infinite extends DivisionResult

// divide (1,2) => Finite(0)
// divide(2,1) => Finite(2)
// divide(1,0) => Infinite

object divide {
  def apply(numerator: Int, denominator: Int) =
    if (denominator == 0) Infinite else Finite(numerator / denominator)
}

object Test extends App {
  divide(1, 0) match {
    case Finite(value) => s"It's finite: ${value}"
    case Infinite => "It's infinite"
  }
}