package example

/*
sealed trait TrafficLight {
  def next: TrafficLight
}

final case object Red extends TrafficLight {
  def next: TrafficLight = Green
}

final case object Green extends TrafficLight {
  def next: TrafficLight = Amber
}

final case object Amber extends TrafficLight {
  def next: TrafficLight = Red
}
*/

// using poly and then PM 
// a method next which returns the next TrafficLight in sequence
// Red -> Green -> Amber -> Red

// method inside or outside the class?
// inside -> PM or poly?

sealed trait TrafficLight {
  def next: TrafficLight =
    this match {
      case Red => Green
      case Green => Amber
      case Amber => Red
    }
}

final case object Red extends TrafficLight

final case object Green extends TrafficLight

final case object Amber extends TrafficLight