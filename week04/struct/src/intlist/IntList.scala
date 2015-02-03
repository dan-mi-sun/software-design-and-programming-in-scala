package intlist

sealed trait IntList

final case object EndOfList extends IntList

final case class Pair(head: Int, tail: IntList) extends IntList

/*
1 -> 2 -> 3 -> EndOfList

(1,(2,(3,EndOfList)))

item next
*/

object Thing extends App {
  def sum(list: IntList): Int =
    list match {
      case EndOfList => 0
      case Pair(hd, tl) => hd + sum(tl)
    }

  val b = Pair(1,Pair(2,Pair(3,EndOfList)))
  println(b)
  println(sum(b))
}