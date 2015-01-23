package comp

case class Person(firstName: String, lastName: String)

object Stormtropper {
  def inspect(p: Person): String =
    p match {
      case Person("Luke", "Skywalker") => "Stop you rebel scum"
      case Person("Han", "Solo") => "Stop Solo"
      case Person(first, _) => s"Move along, $first"
    }
}