package structural.pm

trait B

trait C

case class A(b: B, c: C)

object Poly {
  def foo(a: A) =
    a match {
      case A(b, c) => ???
    }
}

