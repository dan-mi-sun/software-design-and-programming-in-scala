package recursive

sealed trait IntList
final case object End extends IntList
final case class Pair(item: Int, tail: IntList) extends IntList

object Test extends App {
  def sum(list: IntList): Int =
    list match {
      case End => 0
      case Pair(hd, tl) => hd + sum(tl)
    }
  val l = Pair(1, Pair(2, Pair(3, End)))
  println(l)
  println(sum(l))
}


// 1 . (2 -> (3 -> End)))