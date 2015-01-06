package scripts

// Brevity1.scala
import com.atomicscala.AtomicTest._

object Test {
def filterWithYield1(
  v: Vector[Int]): Vector[Int] = {
  val result = for {
    n <- v
    if n < 10
    if n % 2 != 0
  } yield n
  result
}                                                 //> filterWithYield1: (v: Vector[Int])Vector[Int]

val v = Vector(1, 2, 3, 5, 6, 7, 8, 10, 13, 14, 17)
                                                  //> v  : scala.collection.immutable.Vector[Int] = Vector(1, 2, 3, 5, 6, 7, 8, 10
                                                  //| , 13, 14, 17)
filterWithYield1(v) is Vector(1, 3, 5, 7)         //> Vector(1, 3, 5, 7)
}