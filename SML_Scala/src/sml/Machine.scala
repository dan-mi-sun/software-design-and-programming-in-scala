package sml

import java.util.ArrayList
import Machine._

object Machine {
  def main(args: Array[String]) {
    val m = Translator(args(0)).readAndTranslate(new Machine())
    println("Here is the program; it has " + m.prog.size + " instructions.")
    println(m)
    println("Beginning program execution.")
    m.execute()
    println("Ending program execution.")
    println("Values of registers at program termination:")
    println(m.registers + ".")
  }
}

case class Machine() {

  private var labels: Labels = new Labels()

  private var prog: Vector[Instruction] = Vector()

  private var registers: Registers = _

  private var pc: Int = 0

  override def toString(): String = {
    val s = new StringBuffer()
    var i = 0
    prog.foldLeft("")(_ + _)
  }

  def execute() {
    pc = 0
    registers = new Registers()
    while (pc < prog.size) {
      val ins = prog(pc)
      pc += 1
      ins execute this
    }
  }
}

