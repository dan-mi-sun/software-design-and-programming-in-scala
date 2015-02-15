package genericstwo

// partial functions -> "currying"

object Func extends App {

  def part[A, B, C](a: A, fn: (A, B) => C): (B => C) =
    (b: B) => fn(a, b)

  def compose[A, B, C](f: B => C, g: A => B): A => C =
    (a: A) => f(g(a))


  val add3 = part(3, (a: Int, b: Int) => a + b)
  val add6 = part(6, (a: Int, b: Int) => a + b)
  println(add3(6))
  println(add6(6))

  val double = (x: Double) => 2.0 * x

  val squared = (x: Double) => x * x

  println(compose(double,squared)(3))
  //val x = double compose squared
  //println(x(3))

}
