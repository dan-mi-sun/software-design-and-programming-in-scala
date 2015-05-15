/*
 * Suppose we want to sort a list of numbers (in ascending order) - how might we achieve this?
 *
 * We could sort the list by sorting the tail of the list and inserting the head element in its
 * correct position in the list (i.e., Insert sort).
 */


object Isort extends App {

  def isort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case hd :: tl => insert(hd, isort(tl))
  }

  def insert(x: Int, lst: List[Int]): List[Int] = lst match {
    case List() => List(x)
    case hd :: tl => if (x <= hd) x :: lst else hd :: insert(x, tl)
  }

  println(isort(List(7,2,17,8,6)))
}
