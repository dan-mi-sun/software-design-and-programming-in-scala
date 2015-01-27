package seals

sealed trait Shape {
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

// seal Shape
// singleton Draw apply method which takes a Shape -> prints out description

object Draw {
  def apply(s: Shape) =
    s match {
    case Rectangle(width,height) => println(s"A rectangle with width ${width}")
    case Square(size) => println(s"A square with side ${size}")
    case Circle(radius) => println(s"A circle with radius ${radius}")
    case _ => println("Some other shape")
  }
}