package sml

class Translator(fileName: String) {
  private var labels: Vector[String] = Vector()
  private var program: Vector[Instruction] = Vector()

  private final val ADD = "add"
  private final val LIN = "lin"

  def readAndTranslate(m: Machine): Machine = {
    import scala.io.Source
    val lines = Source.fromFile(fileName).getLines
    for (line <- lines) {
      var fields = line.split(" ")
      if (fields.length > 0) {
        labels = labels :+ fields(0)
        fields(1) match {
          case ADD =>
            program = program :+ AddInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case LIN =>
            program = program :+ LinInstruction(fields(0), fields(2).toInt, fields(3).toInt)
          case x =>
            println(s"Unknown instruction $x")
        }
      }
    }
    new Machine(labels, program)
  }
}

object Translator {
  private val fileName: String = "src/"

  def apply(file: String) =
    new Translator(fileName + file)
}