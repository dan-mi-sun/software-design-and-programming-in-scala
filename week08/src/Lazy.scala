object Lazy extends App {
  lazy val resource: Int = meth()

  def meth(): Int = {
    // do something expensive
    println("doing something expensive")
    0
  }

}


