/*
 * Merge sort -
 *
 * Separate the list into two sub-lists, each with (roughly) half the elements of the original list
 * Sort the two sub-lists
 * Merge the two sorted sub-lists into a single, sorted list
 */

object MergeSort extends App {

  def mergesort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = xs match {
        case Nil => ys
        case hd :: tl =>
          ys match {
            case Nil => xs
            case hd1 :: tl1 =>
              if (lt(hd, hd1)) hd :: merge(tl, ys)
              else hd1 :: merge(xs, tl1)
          }
      }
      val (first, second) = xs splitAt n
      merge(mergesort(first)(lt), mergesort(second)(lt))
    }
  }

  println(mergesort(List(9, 4, 8, 12, 56, 2, 678, 12, 4, 9))((x, y) => x < y))
  println(mergesort(List("apple", "pear", "orange", "pineapple"))((x, y) => x.compareTo(y) < 0))

  def mergesortOrd[T](xs: List[T])(ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = xs match {
        case Nil => ys
        case hd :: tl =>
          ys match {
            case Nil => xs
            case hd1 :: tl1 =>
              if (ord.lt(hd, hd1)) hd :: merge(tl, ys)
              else hd1 :: merge(xs, tl1)
          }
      }
      val (first, second) = xs splitAt n
      merge(mergesortOrd(first)(ord), mergesortOrd(second)(ord))
    }
  }

  println(mergesortOrd(List(9, 4, 8, 12, 56, 2, 678, 12, 4, 9))(Ordering.Int))
  println(mergesortOrd(List("apple", "pear", "orange", "pineapple"))(Ordering.String))

  def mergesortOrdImp[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = xs match {
        case Nil => ys
        case hd :: tl =>
          ys match {
            case Nil => xs
            case hd1 :: tl1 =>
              if (ord.lt(hd, hd1)) hd :: merge(tl, ys)
              else hd1 :: merge(xs, tl1)
          }
      }
      val (first, second) = xs splitAt n
      merge(mergesortOrdImp(first), mergesortOrdImp(second))
    }
  }

  println(mergesortOrdImp(List(9, 4, 8, 12, 56, 2, 678, 12, 4, 9)))
  println(mergesortOrdImp(List("apple", "pear", "orange", "pineapple")))

}
