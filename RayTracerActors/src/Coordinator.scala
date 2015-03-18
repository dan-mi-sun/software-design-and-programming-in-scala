import scala.actors.Actor

// messages to Coordinator
case class Set(x: Int, y: Int, color: Color)

object Coordinator extends Actor {
  // Number of pixels we're waiting for to be set.
  var waiting = 0
  var outfile: String = null
  var image: Image = null

  def init(im: Image, of: String) = {
    image = im
    outfile = of
    waiting = image.width * image.height
  }

  def act {
    loop {
      react {
        case Set(x, y, c) => {
          image(x, y) = c
          waiting -= 1
          if (waiting == 0) {
            print
            exit
          }
        }
      }
    }
  }

  def print = {
    assert(waiting == 0)
    image.print(outfile)
  }
}
