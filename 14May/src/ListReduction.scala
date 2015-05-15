object ListReduction extends App {
  def sum(xs: List[Double]): Double = xs match {
    case Nil => 0
    case hd :: tl => hd + sum(tl)
  }

  def sum2(xs:List[Double]):Double = (0.0::xs) reduceLeft (_ + _)
  def product2(xs:List[Double]):Double = (1.0::xs) reduceLeft (_ * _)

  def sum3(xs:List[Double]):Double = (xs foldLeft 0.0) (_ + _)
  def product3(xs:List[Double]):Double = (xs foldLeft 1.0) (_ * _)


  val x:List[Double] = List(3.4,1.2,-5.23,-6.23,2.0,4.5)

  println(sum(x))
  println(sum2(x))
  println(sum3(x))

  println(product2(x))
  println(product3(x))
}
