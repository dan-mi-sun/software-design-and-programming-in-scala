package hello

import akka.actor.{Actor, ActorSystem, Props}

class HelloActor extends Actor {
  override def receive = {
    case "hello" => println("hello back at you")
    case _ => println("huh?")
  }
}

object Thing extends App {
  val system = ActorSystem("HelloSystem")
  // default Actor constructor
  val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")
  helloActor ! "hello"
  helloActor ! "buenos dias"
}