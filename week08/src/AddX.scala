object AddX extends App {

  def addX(i: Int) = (j: Int) => i + j

  def addOne = addX(1)
  def addTwo = addX(2)

  println(addOne(5))
  println(addTwo(7))

}
