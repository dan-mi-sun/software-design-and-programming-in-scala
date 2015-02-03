package sml

class Translator(fileName: String) {
  private final val ADD = "add"
  private final val LIN = "lin"

  def readAndTranslate(m: Machine): Machine = {
    val labels = m.labels
    var program = m.prog
    import scala.io.Source
    val lines = Source.fromFile(fileName).getLines
    for (line <- lines) {
      val fields = line.split(" ")
      if (fields.length > 0) {
        labels.add(fields(0))
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
  private val directory: String = "src/"

  def apply(file: String) =
    new Translator(directory + file)
}