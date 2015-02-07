package ll

sealed trait List[T] {
  def length: Int =
    this match {
      case EndOfList() => 0
      case Node(hd, tl) => 1 + tl.length
    }
  
//  def double: List[T] =
//    this match {
//    case EndOfList() => EndOfList()
//    case Node(hd,tl) => Node(hd * 2, tl.double)
//  }
  
  def sum:T =
    this match {
    case EndOfList() => 0
    case Node(hd,tl) => hd + tl.sum
  }
}
final case class EndOfList[T]() extends List[T]
final case class Node[T](head: T, tail: List[T]) extends List[T]

object Test extends App {
  val l = Node(1, Node(2, Node(3, Node(4, EndOfList()))))
  println(l.sum)
  println(l.length)
}