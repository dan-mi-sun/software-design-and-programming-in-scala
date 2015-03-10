package hello

import akka.actor.{ Actor, ActorSystem, Props }

class HelloAct(name: String) extends Actor {
  override def receive = {
    case "hello" => println("hello from " + name)
    case _ => println("I don't understand!")
  }
}


object Main extends App {
  val system = ActorSystem("HelloSystem")
  val helloActor = system.actorOf(Props(new HelloAct("fred")), name = "helloactor")
  helloActor ! "hello"
  helloActor ! "goodbye"
}