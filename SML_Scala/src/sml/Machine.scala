package sml

import java.util.ArrayList
import Machine._

case class Machine(labels: Vector[String], prog: Vector[Instruction]) {
  private final val NUMBEROFREGISTERS = 32
  val regs: Registers = new Registers(NUMBEROFREGISTERS)

  override def toString(): String = {
    prog.foldLeft("")(_ + _)
  }

  def execute(start: Int) =
    Range(start, prog.length).foreach(x => prog(x) execute this)
}

object Machine {
  def main(args: Array[String]) {
    if (args.length == 0) {
      println("Machine: args should be sml code file to execute")
      return
    }
    println("SML interpreter - Scala version")

    val m = Translator(args(0)).readAndTranslate(new Machine(Vector(), Vector()))

    println("Here is the program; it has " + m.prog.size + " instructions.")
    println(m)
    println("Beginning program execution.")
    m.execute(0)
    println("Ending program execution.")
    println("Values of registers at program termination:")
    println(m.regs + ".")
  }
}
