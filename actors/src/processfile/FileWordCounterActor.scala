package processfile

import akka.actor.{Actor, ActorRef, Props }

case class StartProcessingFile()

class FileWordCounterActor(filename: String) extends Actor {
  private var running = false
  private var totalLines = 0;
  private var linesProcessed = 0;
  private var result = 0;
  private var fileSender: Option[ActorRef] = None
  
  def receive = {
    case StartProcessingFile() => {
      println("Processing...")
      if (running){
        println("already running")
      } else {
        running = true
        fileSender = Some(sender) // save reference to the parent process
        import scala.io.Source._
        fromFile(filename).getLines().foreach {
          line => context.actorOf(Props(new WordCountActor())) ! ProcessStringMsg(line)
          println(s"Starting actor $totalLines")
          totalLines += 1
        }
      }
    }
    case StringProcessedMsg(words) => {
      result += words
      linesProcessed += 1
      if (linesProcessed == totalLines) { // finished
         fileSender.map( _ ! result) // send result to invoking process 
      }
      println("Finished...")
    }
    case _ => println("Message not recognised")
  }
}