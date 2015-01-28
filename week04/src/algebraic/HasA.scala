package algebraic

//case class Car(w: Wheels, e: Engine)

trait Wheels

trait Engine

trait Car {
  def w: Wheels
  def e: Engine
}

// ========================= has-a AND pattern PRODUCT type