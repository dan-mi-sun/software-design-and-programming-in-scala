package traits

trait Shape {
  // sides - returns the number of sides
  def sides: Int
  // perimeter - returns the total length of the sides
  def perimeter: Double
  // area - returns that area
  def area: Double
}

// implement Shape with three classes Circle, Rectangle, Square
// appropriate parameters in cons e.g., radius for a circle
// pi -> math.Pi

case class Circle(radius: Double) extends Shape {
  val sides = 1
  val perimeter = 2 * math.Pi * radius
  val area = math.Pi * radius * radius
}

case class Rectangle(width: Double, height: Double) extends Shape {
  val sides = 4
  val perimeter = 2 * width * height
  val area = width * height
}

case class Square(size: Double) extends Shape {
  val sides = 4
  val perimeter = 4 * size
  val area = size * size
}