package helloackka

import akka.actor.{Props, ActorSystem, Actor}

class HelloActor(name: String) extends Actor {
  override def receive = {
    case "hello" => println(s"hello $name back at you")
    case _ => println("I don't understand this message")
  }
}

object MainHelloActor extends App {
  val system = ActorSystem("HelloSystem")
//  val helloActor = system.actorOf(Props[HelloActor], name = "helloActor")
  val helloActor = system.actorOf(Props(new HelloActor("Fred")), name = "helloActor")
  helloActor ! "hello"
  helloActor ! "goodbye"
}
