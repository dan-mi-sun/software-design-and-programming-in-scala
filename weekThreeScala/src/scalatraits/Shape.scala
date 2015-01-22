package scalatraits

trait Shape {
  // three abstract methods
  // sides -> # of sides
  // perimeter
  // area
  def sides: Int
  def perimeter: Double
  def area: Double
}

// three case classes implement Shape -> Circle, Rectangle, Square
// math.Pi

case class Circle(radius: Double) extends Shape {
  val sides = 1
  val perimeter = 2 * math.Pi * radius
  val area = math.Pi * radius * radius
}

trait Rectangular extends Shape {
  def width: Double
  def height: Double
  val sides = 4
  val perimeter = 2 * width + 2 * height
  val area = width * height
}

case class Square(size: Double) extends Rectangular {
  val width = size
  val height = size
}

case class Rectangle(width: Double, height: Double) extends Rectangular

//case class Rectangle(width: Double, height: Double) extends Shape {
//  val sides = 4
//  val perimeter = 2 * width + 2 * height
//  val area = width * height
//}
//
//case class Square(size: Double) extends Shape {
//  val sides = 4
//  val perimeter = sides * size
//  val area = size * size
//}