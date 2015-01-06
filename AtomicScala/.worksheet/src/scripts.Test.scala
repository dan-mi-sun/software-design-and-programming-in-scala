package scripts

// Brevity1.scala
import com.atomicscala.AtomicTest._

object Test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(229); 
def filterWithYield1(
  v: Vector[Int]): Vector[Int] = {
  val result = for {
    n <- v
    if n < 10
    if n % 2 != 0
  } yield n
  result
};System.out.println("""filterWithYield1: (v: Vector[Int])Vector[Int]""");$skip(53); 

val v = Vector(1, 2, 3, 5, 6, 7, 8, 10, 13, 14, 17);System.out.println("""v  : scala.collection.immutable.Vector[Int] = """ + $show(v ));$skip(42); 
filterWithYield1(v) is Vector(1, 3, 5, 7)}
}
