package genericstwo

import scala.annotation.tailrec


// T extends xxxx
// T extends ?     <:
// T super ?       >:
// Student extends Person
// Pair[Student] <=> Pair[Person]

// <% view bound

object Polymorphic extends App {

  def findFirst[T](as: Array[T], value: T): Int = {
    @tailrec
    def helper(n: Int): Int =
      if (n >= as.length) -1
      else if (as(n) == value) n
      else helper(n + 1)
    helper(0)
  }

  def isSorted[T](as: Array[T], gt: (T, T) => Boolean)(implicit x: T => Comparable[T]) : Boolean = {
    // Hint: The array is not sorted if you encounter two adjacent
    // elements for which ord(first,second) returns false
    // depending on your function
    def helper(n: Int): Boolean =
      if (n >= as.length - 1) true
      else if (gt(as(n),as(n+1))) false
      else helper(n + 1)

    helper(0)
  }

//  def gt[T](x: T, y: T): Boolean =
//    x > y

  //println(findFirst(Array("1", "23", "4", "5", "6"), "6"))
  //println(findFirst(Array(1, 23, 4, 5, 6), 5))

  println(isSorted(Array(1,2,3,5,6,1),(a:Int, b) => a > b))

}
