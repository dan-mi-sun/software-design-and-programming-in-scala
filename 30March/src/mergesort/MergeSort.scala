package mergesort

import scala.annotation.tailrec

object MergeSort extends App {

  // split a list in two
  // recursively call the alg on the sublists
  // merge it back together

  // merge takes two sorted lists and glues them back together
  // comparator function required
  // return => a single list

  def merge[T](aList: List[T], bList: List[T])(cmp: (T, T) => Boolean): List[T] = {
    @tailrec
    def mergeHelper(aL: List[T], bL: List[T], accList: List[T]): List[T] =
      (aL, bL) match {
        case (Nil, _) => accList ++ bL        // could use reverse on accList
        case (_, Nil) => accList ++ aL        // to save space (and time?)
        case (x :: xs, y :: ys) =>
          if (cmp(x, y)) mergeHelper(xs, bL, accList :+ x)
          else mergeHelper(aL, ys, accList :+ y)
      }
    mergeHelper(aList, bList, Nil)
  }

  //    (aList, bList) match {
  //      case (Nil, _) => bList
  //      case (_, Nil) => aList
  //      case (x :: xs, y :: ys) =>
  //        if (cmp(x, y)) x :: merge(xs, bList)(cmp)
  //        else y :: merge(aList, ys)(cmp)
  //    }


  val l1 = List(1, 4, 7, 10)
  val l2 = List(2, 3, 5, 7, 12, 16)
  println(merge(l1, l2)((x, y) => x <= y))
  // List(1,2,3,4,5,7,7,10,12,16)

}
