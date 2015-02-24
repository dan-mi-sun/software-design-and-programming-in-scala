object CallByName extends App {

  // while(cond)
  //  body

  def continue(conditional: => Boolean)(body: => Unit) {
    if (conditional) {
      body
      continue(conditional)(body)
    }
  }

  var count = 0
  continue(count < 5) {
    println(s"value of count is $count")
    count += 1
  }
}

/*
  def a = 3
  def b = 5

  def meth(x: Int, y: Int) = {}

  meth(a, b)
}
        */
