package sml

import Registers._
//remove if not needed
import scala.collection.JavaConversions._

object Registers {

  private val NUMBEROFREGISTERS = 32
}

class Registers {

  private var registers: Int = new Int(NUMBEROFREGISTERS)

  var i = 0
  while (i != registers.length) {
    registers(i) = 0
    i += 1
  }

  def setRegister(i: Int, v: Int) {
    registers(i) = v
  }

  def getRegister(i: Int): Int = registers(i)
}