package sml

class Translator(fileName: String) {  
  private var line: String = ""
  private var labels: Labels = _
  private var program: Vector[Instruction] = _
  
    def readAndTranslate(m: Machine): Boolean = {
    import scala.io.Source
    val stream = Source.fromFile(fileName)
    for (lines <- stream.getLines){
      var fields = lines.split(" ")
          if (fields.length > 0) {
            val ins = getInstruction(label)
            if (ins != null) {
              labels.addLabel(label)
              program :+ ins
            }
          }
          try {
            line = sc.nextLine()
          } catch {
            case ioE: NoSuchElementException => return false
          }
        }
      }
    } catch {
      case ioE: IOException => {
        println("File: IO error " + ioE.getMessage)
        return false
      }
    }
    true
  }

  def getInstruction(label: String): Instruction = {
    var s1: Int = 0
    var s2: Int = 0
    var r: Int = 0
    val x: Int = 0
    if (line == "") return null
    val ins = scan()
    ins match {
      case "add" => 
        r = scanInt()
        s1 = scanInt()
        s2 = scanInt()
        return new AddInstruction(label, r, s1, s2)

      case "lin" => 
        r = scanInt()
        s1 = scanInt()
        return new LinInstruction(label, r, s1)

    }
    null
  }
}


object Translator {
  private val fileName: String = "src/"

  def apply(file: String) =
    new Translator(fileName + file)
} 



