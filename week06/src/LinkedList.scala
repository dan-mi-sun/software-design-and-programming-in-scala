// Recursive Algebraic Data Type Pattern

sealed trait LinkedList[T] {

  def fold(end: T, f: (T, T) => T): T =
    this match {
      case EndOfList() => end
      case Pair(hd, tl) => f(hd, tl.fold(end, f))
    }

  def map[U](fn: T => U): LinkedList[U] =
    this match {
      case Pair(hd, tl) => Pair(fn(hd), tl.map(fn))
      case EndOfList() => EndOfList[U]()
    }


  //  def sum =
  //    fold(0, (a, b) => a + b)
  //
  //  def length: T =
  //    fold(0, (_, b) => 1 + b)
  //
  //  def product =
  //    fold(1, (hd, tl) => hd * tl)
}

class Person

class Student extends Person

class PGStudent extends Student

class Academic extends Person

final case class Pair[T](head: T, tail: LinkedList[T]) extends LinkedList[T]

final case class EndOfList[T]() extends LinkedList[T]

object Main extends App {

  val l: LinkedList[Int] = Pair(1, Pair(2, Pair(3, Pair(4, EndOfList()))))
  println(l)
  println(l.map(_ * 2.5))
  println(l.map(_ + 1))
//  println(Pair("asdad", EndOfList()))
//  println(Pair(new Student(), Pair(new Person(), EndOfList())))

  def p: Pair[Student] = Pair(new Student(), Pair(new PGStudent(), EndOfList()))

  //  println(l.sum)
  //  println(l.product)
  //  println(l.length)
  //  println(l.double())
}