package processfile

object Main extends App {
  
  import akka.actor.ActorSystem
  import scala.concurrent.duration._
  import scala.concurrent.ExecutionContext.Implicits.global
  import akka.actor.Props
  import akka.pattern.ask
  import akka.util.Timeout
 
  val system = ActorSystem("system")
  val actor = system.actorOf(Props(new FileWordCounterActor(args(0))))
  
  implicit val timeout = Timeout(30)
  val future = actor ? StartProcessingFile()
  future.map { result => 
    println("Total number of words " + result)
    system.shutdown()  
  }
}