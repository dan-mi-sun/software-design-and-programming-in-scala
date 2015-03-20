package fsm

import akka.actor.{Props, ActorSystem}

object DiningHakkersOnFsm extends App {

  val acsy = ActorSystem()
  val chopsticks =
    for (i <- 0 to 4) yield
    acsy.actorOf(Props[Chopstick], "C" + i)
  val hakkers = for {
    (name, i) <- List("P0", "P1", "P2", "P3", "P4").zipWithIndex
  } yield
    acsy.actorOf(
      Props(classOf[FSMHakker],
        name, chopsticks(i), chopsticks((i + 1) % 5)))
  hakkers.foreach(_ ! Think)
}