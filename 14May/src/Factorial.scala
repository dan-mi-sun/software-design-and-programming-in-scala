import scala.annotation.tailrec

object Factorial extends App{
  def factorial(n: Int): Long =
    factorial(n,1)


  @tailrec
  def factorial(n: Int, acc: Long = 1): Long =
    if (n <= 0)  acc else factorial(n - 1, acc * n)

  def origFactorial(n: Int): Long =
    if (n <= 0) 1 else n * factorial(n-1)


  println(factorial(12))
  println(origFactorial(12))
}
