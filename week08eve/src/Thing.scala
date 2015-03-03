import scala.annotation.tailrec

object Thing extends App {

  def meth(i: Int): Int = ???

  // dog biscuits?
  // formal parameters
  //  - call-by-ref
  //  - call-by-value
  // both of the above evaluate their parameters
  //
  // - call-by-name
  // delayed evaluation (lazy)

  def methName(eval: => Boolean) = {
    println(eval)
    if (eval) {
      println("ug")
    } else {
      println("foo")
    }
  }

  //  var count = 1
  //  methName({println("ddd"); count == 1})
  //  count += 1
  //  methName(count == 1)

  var count = 1
  xxx(count <= 5) {
    println(s"value $count")
    count += 1
  }

  @tailrec
  def xxx(conditional: => Boolean)(body: => Unit): Unit = {
    if (conditional) {
      body
      xxx(conditional)(body)
    }
  }

  def yyy(i: Int)(j: Int): Int = i + j

  //println(yyy(3)(4))
}
