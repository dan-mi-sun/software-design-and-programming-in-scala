package structural.pm

trait Engine

trait Doors

case class Car(e: Engine, d: Doors)

object Poly {
  def foo(c: Car) =
    c match {
      case Car(e, d) => ???
    }
}

