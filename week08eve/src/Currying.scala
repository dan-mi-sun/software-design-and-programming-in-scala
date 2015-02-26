object Currying extends App {
  def cat1(s1: String)(s2: String) = s1 + s2

  def cat2(s1: String) = (s2: String) => s1 + s2

  //  println(cat1("hello ")("world"))
  //  println(cat2("hello ")("world"))

  val f = cat2("Boris ")
  val s = f("the spider")
  //  println(s)

  def addn(n: Int) = (i: Int) => i + n

  val add5 = addn(5)

  println(add5(10))
  println(add5(13))

  val add7 = addn(7)

  println(add7(10))
  println(add7(13))

}
