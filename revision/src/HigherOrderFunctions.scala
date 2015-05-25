import scala.annotation.tailrec

object HigherOrderFunctions extends App {

  def scaleList(xs: List[Double], factor: Double): List[Double] = xs match {
    case Nil => Nil
    case hd :: tl => hd * factor :: scaleList(tl, factor)
  }

  def scaleListTailRecursive(xs: List[Double], factor: Double): List[Double] = {
    @tailrec
    def helper(acc: List[Double], xs: List[Double]): List[Double] = xs match {
      case Nil => acc
      case hd :: tl => helper(hd * factor :: acc, tl)
    }
    helper(List(), xs).reverse
  }


  def squareList(xs: List[Double]): List[Double] =
    xs map (x => x * x)

  def posElements(xs: List[Double]): List[Double] =
    xs filter (x => x > 0)

  def notPosElements(xs: List[Double]): List[Double] =
    xs filterNot (x => x > 0)

  val x: List[Double] = List(3.5, 1.2, -5.3, 8.1, -7.3)

  println(x)
  println(scaleList(x, 0.5))
  println(scaleListTailRecursive(x, 0.5))
  println(squareList(x))
  println(posElements(x))
  println(notPosElements(x))
  println(x partition (x => x > 0))    // single pass
  println(x takeWhile (x => x > 0))
  println(x dropWhile (x => x > 0))
  println(x span (x => x > 0))   // single pass = more efficient
}
