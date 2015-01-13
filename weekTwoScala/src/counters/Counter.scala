package counters

class Counter(val count: Int) {
  def dec = new Counter(count - 1)
  def inc = new Counter(count + 1)
  def adjust(adder: Adder) =
    new Counter(adder.add(count))
}

class Adder(amount: Int) {
  def add(in: Int) = in + amount
}

object Test {
  def main(args: Array[String]): Unit = {
    println(new Counter(5).inc.dec.inc.inc.count)
  }
}