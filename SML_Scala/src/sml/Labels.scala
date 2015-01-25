package sml

case class Labels() {
  var labels: Seq[String] = Seq()

  override def toString(): String =
    labels.mkString(" : ")
    
  def add(l: String) = labels = labels :+ l  
  def apply(k: Int) = labels(k)
}