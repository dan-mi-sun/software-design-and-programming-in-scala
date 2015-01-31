package structural.poly

sealed trait Feline {
  def dinner: Food
}

final case class Lion() extends Feline {
  def dinner: Food = Antelope
}

final case class Tiger() extends Feline {
  def dinner: Food = TigerStuff
}

final case class Panther() extends Feline{
  def dinner: Food = TigerStuff
}

final case class Cat(favFood: String) extends Feline{
  def dinner: Food = CatFood(favFood)
}

// Lion, Tiger, Panther, Cat

sealed trait Food
final object Antelope extends Food
final object TigerStuff extends Food
final case class CatFood(food: String) extends Food

