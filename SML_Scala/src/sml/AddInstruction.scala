package sml

class AddInstruction(label: String, op: String, val op1:String, val op2: String) extends Instruction(label, op) {

  override def execute(m: Machine) {
    val value1 = m.getRegisters.getRegister(op1)
    val value2 = m.getRegisters.getRegister(op2)
    m.getRegisters.setRegister(result, value1 + value2)
  }

  override def toString(): String = {
    super.toString + " " + op1 + " + " + op2 + " to " + result
  }
}