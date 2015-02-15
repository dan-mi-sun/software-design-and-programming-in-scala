// T <: upperbound
// T >: lowerbound
// T <% viewbound
// T : contextbound

// +T - covariance
// -T - contravariance

case class Pair[T <: Comparable[T]](first: T, second: T){
  def smaller = if (first.compareTo(second) < 0) first else second
}

val p1 = new Pair(123,57)
p1.smaller








//new Pair(42,"string")

//new Pair[Any,Any](42,"string")

//def getMiddle[T](a: Array[T]) = a(a.length/2)

//val a = Array(1,2,3)

//getMiddle(a)

//val s = Array("a","b","c")

//getMiddle(s)
