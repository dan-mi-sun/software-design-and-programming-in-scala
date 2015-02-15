package generics

// T <: upperbound
// T >: lowerbound
// T <% viewbound

// T <: upper >: lower
// T <: Comparable[T] with Serializable with Cloneable

// T : contextbound

// +T  covariance
// -T  contravariance

//case class Pair[T <% Comparable[T]](first: T, second: T) {
//  def smaller = if (first.compareTo(second) < 0) first else second
class Person // extends Friend[Person]
class Student extends Person
class PGStudent extends Student
class Academic extends Person

//case class Pair[T](first: T, second: T) {
//def replaceFirst[R >: T](newFirst: R) =
////   def replaceFirst(newFirst: T) =   try with +T or -T
//    new Pair[R](newFirst, second)
//}

// Pair[Student] subclass of Pair[Person]

case class Pair[+T](first:T, second:T)

trait Friend[-T] {
  def befriend(someone: T)  = ???
}

object Test extends App {
  val l = Pair(new PGStudent(),new Student())
  println(l)
//  println(l.replaceFirst(new Person()))


  def makeFriendWith(s: Student, f: Friend[Student]): Unit ={
    f.befriend(s)
  }

  val fred = new Student
  val joan = new Person

  //makeFriendWith(fred,joan)


  //new Pair(42,"string")
  //new Pair[Any,Any](42,"string")

  //def getMiddle[T](a: Array[T]) = a(a.length/2)
  //val a = Array(1,2,3)
  //getMiddle(a)
  //val s = Array("a","b","c")
  //getMiddle(s)

//  val p1 = new Pair(3,4)
//  println(p1.replaceFirst(6))

//  println(p1.smaller)
}








