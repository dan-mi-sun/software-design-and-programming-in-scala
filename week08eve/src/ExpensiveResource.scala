object ExpensiveResource extends App {
  lazy val resource: Int = init()

  def init(): Int = {
    // do something expensive
    println("Ouch!")
    0
  }

  //println(resource)
}
