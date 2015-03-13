package newpingpong

import akka.actor.{Props, ActorRef, ActorSystem, Actor}

case object PingMessage
case object PongMessage
case object StartMessage
case object StopMessage

class Ping(pong: ActorRef) extends Actor {
  var count = 0

  def incAndPrint: Unit = {
    count += 1
    println("Ping")
  }
  override def receive = {
      case StartMessage =>
        incAndPrint; pong ! PingMessage
      case PongMessage =>
        incAndPrint
        if (count < 100)
          sender ! PingMessage
        else {
          sender ! StopMessage; println("ping stopping"); context.stop(self)
        }
      case _ => println("can't understand message")
  }
}

class Pong extends Actor {
  override def receive = {
    case PingMessage =>
      println("\tPong"); sender ! PongMessage
    case StopMessage =>
      println("\npong stopping"); context.stop(self)
    case _ => println("can't understand message")
  }
}

object PingPong extends App {
  val system = ActorSystem("PingPongSystem")
  val pong = system.actorOf(Props[Pong], name = "pongactor")
  val ping = system.actorOf(Props(new Ping(pong)), name = "pingactor")
  // on starting orders...
  ping ! StartMessage
}

