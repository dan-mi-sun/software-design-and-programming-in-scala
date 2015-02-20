object Term extends App {
  //  1 until 9 foreach (x => dodgy(x))

  //  def dodgy(x: Int) = {
  //    if (x == 7) exit
  //
  //  }


  def divByFive(n: Int): Option[Int] = {
    println("processing " + n)
    if (n % 5 == 0) Some(n) else None
  }

  ((None: Option[Int]) /: (1 to 11))((a, b) => {
    println(a)
    println(b)
    if (a != None) a else divByFive(b)
  }
  )
}
