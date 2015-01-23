package caseclasses

object Stormtrooper {
  def inspect(person: Person): String =
    person match {
      case Person("Luke", "Skywalker") =>
        "Stop, rebel scum!"
      case Person("Dave", "Grohl") =>
        "Hello, god like person - the nicest man in rock'n'roll"
      case Person(fff, _) =>
        s"Move along $fff"
    }
  //    if (person.firstName == new Person("Luke", "Skywalker"))
  //      "Stop, rebel scum!"
  //    else if...
}

object Testie {
  def main(args: Array[String]): Unit = {
    println(Stormtrooper.inspect(Person("Dave", "Grohl")))
    println(Stormtrooper.inspect(Person("James", "Wilding")))
  }
}