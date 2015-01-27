package algebraic

//case class A(b: B, c: C)

trait B

trait C

trait A {
  def b: B
  def c: C
}

// ========================= has-a AND pattern PRODUCT type