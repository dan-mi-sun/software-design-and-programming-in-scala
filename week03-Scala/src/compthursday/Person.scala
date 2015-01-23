package compthursday

class Person(val firstName: String, val lastName: String)

// add companion object for Person that takes a single string and 
// splits it into the separate firstName lastName components

// Person("Dave Grohl")

object Person {
  def apply(name: String) = {
    val parts = name.split(" ")
    new Person(parts(0), parts(1))
  }
}