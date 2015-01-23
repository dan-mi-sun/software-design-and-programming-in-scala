package sml

case class LinInstruction(label: String, opcode: String, register: Int, value:Int) extends Instruction(label, opcode) {
 
  override def execute(m: Machine) {
    m.getRegisters.setRegister(register, value)
  }

  override def toString(): String = {
    super.toString + " register " + register + " value is " + 
      value
  }
}