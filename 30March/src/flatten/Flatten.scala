package flatten

object Flatten extends App {

  def flatten(ls: List[Any]): List[Int] = {
    //    ls match {
    //      case Nil => Nil
    //      case (x: Int) :: xs => x :: flatten(xs)
    //      case (x: List[Any]) :: xs => flatten(x) ++ flatten(xs)
    //    }

    def flattenHelper(ls: List[Any], tl: List[Int]): List[Int] =
      ls match {
        case Nil => tl
        case (x: Int) :: xs => x :: flattenHelper(xs, tl)
        case (x: List[Any]) :: xs => flattenHelper(x, flattenHelper(xs, tl))
      }

    flattenHelper(ls, Nil)
  }


  var l: List[Any] = List()
  println(flatten(l))
  l = List(1, 2, 3)
  println(flatten(l))
  l = List(1, 2, List(3, 4, 5), List(4, 5, 67, List()), 778)
  println(flatten(l))
  l = List(1, 2, "asdad", 4)
  flatten(l)

}
