package hellotwo

import akka.actor.{Actor, ActorSystem, Props}

// (1) changed the constructor here
class HelloActor(myName: String) extends Actor {
  override def receive = {
    // (2) changed these println statements
    case "hello" => println("hello from %s".format(myName))
    case _ => println("'huh?', said %s".format(myName))
  }
}

object Main extends App {
  val system = ActorSystem("HelloSystem")
  val helloActor = system.actorOf(Props(new HelloActor("Fred")), name = "helloactor")
  helloActor ! "hello"
  helloActor ! "buenos dias"
}
