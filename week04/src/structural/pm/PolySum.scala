package structural.pm

sealed trait Person

case class Student() extends Person

case class Academic() extends Person

object PolySum {
  def f(p: Person) =
    p match {
      case Student() => ???
      case Academic() => ???
    }
}