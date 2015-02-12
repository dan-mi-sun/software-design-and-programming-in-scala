package forcomp

object MapExample extends App {
  val v = Vector(1, 12, 3, 14)
  //  val v2 = Vector("asd","sdasdas")
  //  println(v.map(x => x * x))

  //  for (x <- v)
  //    println(x)
  //
  //  for(x <- Range(0,10))
  //    println(x)


  //  v.foreach(n => println("> " + n))
  //
  //  val duck = "Duck".toVector
  //  duck.foreach(n => println("> " + n))

  //  Range(0,10).foreach(n => println("> " + n))


  //  println(v.sorted)
  //  println(v.sortWith((i,j) => j < i))

  // for comprehensions -> generator, filter, and definitions

  v.reduce((x,y) => y)

  val vec = Vector(1, 2, 3, 5, 6, 7, 8, 10, 13, 14, 17, 19)

  def evenGT5(v: Vector[Int]): Vector[Int] = {
    var result = Vector[Int]()
    for {
      i <- v
      if i % 2 == 0
      if i > 5
    } result = result :+ i
    result
  }

  def evenGT4(v: Vector[Int]) = {
    //val result = for {
    for {
      i <- v
      isOdd = (i % 2 == 0)
      if isOdd
      if i > 4
    } yield //i
    {
      val u = i * 2
      u + 3
    }
    //result
  }

  println(evenGT5(vec))
  println(evenGT4(vec))
}


