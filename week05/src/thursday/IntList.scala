package thursday

// Recursive Algebraic Data Type Pattern

sealed trait IntList {

  //  import scala.annotation.tailrec

  //  def sum(total: Int = 0): Int =
  //    this match {
  //      case EndOfList => total
  //      case Pair(hd, tl) => tl.sum(hd + total)
  //    }
  //
  //  def product(total: Int = 1): Int =
  //    this match {
  //      case EndOfList => total
  //      case Pair(hd, tl) => tl.product(hd * total)
  //    }
  //
  //  def length(total: Int = 0): Int =
  //    this match {
  //      case EndOfList => total
  //      case Pair(hd, tl) => tl.length(1 + total)
  //    }

  // abstract over methods

  def fold(end: Int, f: (Int, Int) => Int): Int =
    this match {
      case EndOfList => end
      case Pair(hd, tl) => f(hd, tl.fold(end, f))
    }

  /*
  abstraction(0,lam) -> f(1,p..2,3,4,E.abstraction(0,lam))
  p..2,3,4,E.abstraction(0,lam) -> f(2,p..3,4,E.abstraction(0,lam))
  p..2,3,4,E.abstraction(0,lam) -> f(3,p..4,E.abstraction(0,lam))
  p..3,4,E.abstraction(0,lam) -> f(4,p..E.abstraction(0,lam))
  p..4,E.abstraction(0,lam) -> E.abstraction(0,lam)
  E.abstraction(0,lam) = 0

  f(x,y) = x + y
   */

  def sum: Int =
    fold(0, (a, b) => a + b)

  def length: Int =
    fold(0, (_, b) => 1 + b)

  def product =
    fold(1, (hd, tl) => hd * tl)
}

//  def double(list: IntList): IntList =
//    list match {
//      case EndOfList => EndOfList
//      case Pair(hd, tl) => Pair(hd * 2, double(tl))
//    }

//  def sum(list: IntList): Int =
//    list match {
//      case EndOfList => 0
//      case Pair(hd, tl) => hd + sum(tl)
//    }

final case class Pair(head: Int, tail: IntList) extends IntList

case object EndOfList extends IntList

object Main extends App {

  def l = Pair(1, Pair(2, Pair(3, Pair(4, EndOfList))))

  println(l)
  println(l.sum)
  println(l.product)
  println(l.length)
  //  println(l.double())
}