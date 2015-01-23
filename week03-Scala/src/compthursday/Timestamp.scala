package compthursday


// Companion Object Syntax

class Timestamp(val seconds: Long)

object Timestamp {
  def apply(hours: Int, minutes: Int, seconds: Int) =
    new Timestamp(hours * 60 * 60 + minutes * 60 + seconds)
}