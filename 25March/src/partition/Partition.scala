package partition

import scala.annotation.tailrec
import scala.util.Random

object Partition extends App {
  def partition(list: Seq[Int], pivot: Int): (Seq[Int], Seq[Int]) = {
    @tailrec
    def partitionWork(list: Seq[Int], pivot: Int, accum: (Seq[Int], Seq[Int])): (Seq[Int], Seq[Int]) =
    list match  {
      case Nil =>
        // reached the end of the list, so the partitions are complete
        accum
      case first :: tail =>
        if (first < pivot)
        // first value goes in the left partition
          partitionWork(tail, pivot, (first +: accum._1, accum._2))
        else
        // first value goes in the right partition
          partitionWork(tail, pivot, (accum._1, first +: accum._2))
    }
    partitionWork(list, pivot, (List(), List()))
  }

  def randomIntList(n: Int): Seq[Int] = {
    val r = new Random()

    @tailrec
    def randomIntListWork(n: Int, accum: Seq[Int]): Seq[Int] = {
      if (n == 0)
        accum
      else
        randomIntListWork(n - 1, r.nextInt(1000) +: accum)
    }
    randomIntListWork(n, List())
  }

  def quickSort(list: Seq[Int]): Seq[Int] = {
    if (list == Nil || list.tail == Nil)
      list
    else {
      val pivot = list.head
      val partitions = partition(list.tail, pivot)
      return quickSort(partitions._1) ++: (pivot +: quickSort(partitions._2))
    }
  }

  val list = randomIntList(10)

  println("Original list: " + list)

  val first = list.head
  val partitioned = partition(list, first)

  println("After partitioning on first element " + first)
  println(partitioned)

  println("Sorted:")
  println(quickSort(list))

}



