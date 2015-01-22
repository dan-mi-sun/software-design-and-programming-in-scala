package caseclasses

case class Person(firstName: String, lastName: String){
  def name = firstName + " " + lastName
}

object Test {
  def main(args: Array[String]) = {
    val p = new Person("Philip", "Schofield")
    val p1 = new Person("Philip", "Schofield")
    val p2 = p1.copy()
    println(p)
    println(p1)
    println(p.equals(p1))
    println(p == p1)
    println(p eq p1)
    println(p1 equals p2)
  }
}