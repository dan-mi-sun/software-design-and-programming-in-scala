object Expression extends App {

  println(Exp.evaluate(Plus(Mul(Num(3), Num(4)), Sub(Num(3), Num(4)))))
}

sealed trait Exp

final case class Num(n: Int) extends Exp

final case class Plus(n1: Exp, n2: Exp) extends Exp

final case class Mul(n1: Exp, n2: Exp) extends Exp

final case class Sub(n1: Exp, n2: Exp) extends Exp

object Exp {
  def evaluate(e: Exp): Int = e match {
    case Num(n) => n
    case Plus(n1, n2) => evaluate(n1) + evaluate(n2)
    case Mul(n1, n2) => evaluate(n1) * evaluate(n2)
    case Sub(n1, n2) => evaluate(n1) - evaluate(n2)
  }
}
