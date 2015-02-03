package ll

sealed trait IntList {
  def length: Int =
    this match {
      case EndOfList => 0
      case Node(hd, tl) => 1 + tl.length
    }
  
  def double: IntList =
    this match {
    case EndOfList => EndOfList
    case Node(hd,tl) => Node(hd * 2, tl.double)
  }
  
  def sum:Int =
    this match {
    case EndOfList => 0
    case Node(hd,tl) => hd + tl.sum
  }
}
final case object EndOfList extends IntList
final case class Node(head: Int, tail: IntList) extends IntList

object Test extends App {
  val l = Node(1, Node(2, Node(3, Node(4, EndOfList))))
  println(l.sum)
  println(l.length)
/*
  import scala.annotation.tailrec

  @tailrec
  def sum(list: IntList, total: Int = 0): Int =
    list match {
      case EndOfList => total
      case Node(hd, tl) => sum(tl, hd + total)
    }

  def length(list: IntList): Int =
    list match {
      case EndOfList => 0
      case Node(hd, tl) => 1 + length(tl)
    }
 
*/
}