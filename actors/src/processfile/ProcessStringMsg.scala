package processfile

case class ProcessStringMsg(str: String)
case class StringProcessedMsg(words: Integer)

import akka.actor.Actor

class WordCountActor extends Actor {

  override def preStart = {
    println("Start -> " + context.self)
  }

  override def receive = {
    case ProcessStringMsg(str) => {
      val wordsInLine = str.split(" ").length
      sender ! StringProcessedMsg(wordsInLine)
    }
    case _ => println("Error: message not recognized")
  }

  override def postStop = {
    println("Stop -> " + context.self)
  }
}