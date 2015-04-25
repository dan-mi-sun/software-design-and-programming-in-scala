package power

import scala.io.StdIn.{readDouble, readInt}

object Raise extends App {

  def raiseToPower(base: Double, power: Integer): Option[Double] = {
    def raiseToPowerWork(base: Double, power: Integer, accum: Double): Option[Double] = {
      if (power == 0)
        Some(accum)
      else
        raiseToPowerWork(base, power - 1, accum * base)
    }

    if (power <= 0)
      None
    else
      raiseToPowerWork(base, power, 1.0)
  }

  print("Enter b: ")
  val b = readDouble()
  print("Enter k: ")
  val k = readInt()

  println(raiseToPower(b, k).getOrElse(s"Invalid value $k"))


}
