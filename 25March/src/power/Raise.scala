package power

import scala.io.StdIn.{readDouble, readInt}

object Raise extends App {

  def raiseToPower(base: Double, power: Integer): Double = {
    def raiseToPowerWork(base: Double, power: Integer, accum: Double): Double = {
      if (power == 0)
        accum
      else
        raiseToPowerWork(base, power - 1, accum * base)
    }

    raiseToPowerWork(base, power, 1.0)
  }

  print("Enter b: ")
  val b = readDouble()
  print("Enter k: ")
  val k = readInt()

  println(raiseToPower(b, k))


}
