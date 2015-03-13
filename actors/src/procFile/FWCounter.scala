package procFile

import akka.actor.{ActorSystem, Actor, ActorRef, Props}
import akka.util.Timeout

case class StartProcessingFile()

case class ProcessLineMsg(line: String)

case class ProcessedLine(words: Int)

class FileOfWordsCounter(fileName: String) extends Actor {
  private var running = false
  private var fileSender: Option[ActorRef] = None
  private var lineCounter = 0
  private var runningTotal = 0
  private var linesProcessed = 0

  override def receive = {
    case StartProcessingFile =>
      if (running) {
        println("...already running")
      } else {
        println("started running...")
        running = true
        fileSender = Some(sender) // save ref to parent process

        import scala.io.Source._
        fromFile(fileName).getLines().foreach {
          line => {
            context.actorOf(Props[WordCounterActor], "wcactor" + lineCounter) ! ProcessLineMsg(line)
            println(s"starting actor " + "wcactor" + lineCounter)
            lineCounter += 1
          }
        }
      }
    case ProcessedLine(words) =>
      runningTotal += words
      linesProcessed += 1
      if (linesProcessed == lineCounter){
        fileSender.map(_ ! runningTotal)
      }
    case _ => println("ajhsgdjhasgd")
  }
}

class WordCounterActor extends Actor {

  override def receive = {
    case ProcessLineMsg(line) =>
      val wordsInLine = line.split(" ").length
      sender ! ProcessedLine(wordsInLine)
    case _ => println("aaaaah!")
  }

}

import akka.pattern.ask
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object LineCounter extends App {
  val system = ActorSystem("wordCountSystem")
  val actor = system.actorOf(Props(new FileOfWordsCounter(args(0))), "filewcactors")

  implicit val timeout = Timeout(30 seconds)
  val future = actor ? StartProcessingFile
  future.map { result =>
    println("Total number of words is " + result)
    system.shutdown()
  }
}