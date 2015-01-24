package sml

case class Registers(size: Int) {
  val registers: Array[Int] = new Array(size)

  override def toString(): String =
    registers.mkString(" ")

  def update(k: Int, v: Int) = registers(k) = v
  def apply(k: Int) = registers(k)
}