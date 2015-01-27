package structural.poly

// product type OR pattern

sealed trait A {
  def foo: String= "It's a A!"
}

final case class B() extends A {
  override def foo: String = "It's a B!"
}

final case class C() extends A {
  override def foo: String = "It's a C!"
}