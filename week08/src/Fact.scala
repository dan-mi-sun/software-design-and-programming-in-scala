object Fact extends App {

  import scala.annotation.tailrec

  def factorial(i: Int) = {
    @tailrec
    def fact(i: Int, acc: Int): Long = {
      if (i <= 1) acc
      else fact(i - 1, i * acc)
    }

    fact(i, 1)
  }

  (0 to 5) foreach (i => println(factorial(i)))

}
