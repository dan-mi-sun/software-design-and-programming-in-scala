// Utilises the "old" Scala actors

object Trace extends App {
  val Width = 800
  val Height = 600

  if (args.length != 2) {
    println("usage: input.dat output.png")
    System.exit(-1)
  }

  val (infile, outfile) = (args(0), args(1))
  val scene = Scene.fromFile(infile)

  render(scene, outfile, Width, Height)

  def render(scene: Scene, outfile: String, width: Int, height: Int) = {
    val image = new Image(width, height)

    // Init the coordinator -- must be done before starting it.
    Coordinator.init(image, outfile)
    Coordinator.start

    scene.traceImage(width, height)
  }
}
