package seals

object divide {
  def apply(numerator: Int, denominator: Int): DivisionResult =
    if (denominator == 0) Infinite else Finite(numerator / denominator)
}

// DR = sealed trait with two subtypes
sealed trait DivisionResult

// Finite - wraps result that is okay  
final case class Finite(value: Int) extends DivisionResult

// Infinite - represents dividing by zero
final case object Infinite extends DivisionResult