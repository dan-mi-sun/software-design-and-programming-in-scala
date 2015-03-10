package bat

import akka.actor.{ Actor, ActorSystem, Props, ActorRef }

case object PingMsg
case object PongMsg
case object StartMsg
case object StopMsg

class Ping(pong: ActorRef) extends Actor {
  var count = 0;

  def incAndPrint {
    count += 1; println("ping")
  }

  override def receive = {
    case StartMsg =>
      incAndPrint
      pong ! PingMsg
    case PongMsg =>
      incAndPrint
      if (count >= 100) {
        sender ! StopMsg
        println("\nping stopped")
        context.stop(self)
      } else {
        sender ! PingMsg
      }
    case _ => println("Sorry I don't understand that message")
  }
}

class Pong extends Actor {
  override def receive = {
    case PingMsg =>
      println("\tpong")
      sender ! PongMsg
    case StopMsg =>
      println("\tpong stopped")
      context.stop(self)
    case _ => println("Sorry I don't understand that message")
  }
}

object PingPong extends App {
  val system = ActorSystem("PingPong")
  val pong = system.actorOf(Props(new Pong()), "pong")
  val ping = system.actorOf(Props(new Ping(pong)), "ping")
  ping ! StartMsg
}