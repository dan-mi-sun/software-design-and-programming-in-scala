object Curry extends App {

  def cat1(s1: String, s2: String) =
    s1 + s2

  def cat2(s1: String)(s2: String) =
    s1 + s2

  def cat3(s1: String) = (s2: String) => s1 + s2

  val cat1Curried = (cat1 _).curried

  println(cat1("Hello ", "dodge"))
  println(cat2("Hello ")("dodge"))
  println(cat3("Hello ")("dodge"))
  val l = cat3("Hello ")

  println(l("betty"))
  println(l("rita"))

  //println(cat1("XXX ")("YYY"))
  println(cat1Curried("XXX ")("YYY"))
}
