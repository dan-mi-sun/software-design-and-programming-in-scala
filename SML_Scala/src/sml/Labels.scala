package sml

import java.util.ArrayList

class Labels {

  private var labels: Vector[String] = new Vector()

  def addLabel(lab: String): Int = {
    labels.add(lab)
    labels.size - 1
  }

  def indexOf(lab: String): Int = {
    var i = 0
    while (i != labels.size) {
      if (lab == labels.get(i)) {
        return i
      }
      i += 1
    }
    -1
  }

  override def toString(): String = {
    val r = new StringBuilder("(")
    var i = 0
    while (i != labels.size) {
      if (i == 0) {
        r.append(labels.get(i))
      } else {
        r.append(", ").append(labels.get(i))
      }
      i += 1
    }
    r.append(")")
    r.toString
  }

  def reset() {
    labels.clear()
  }
}