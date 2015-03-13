import java.io.File
import javax.imageio.ImageIO
import java.awt.image.BufferedImage

object Trace {

  val AntiAliasingFactor = 4
  val Width = 800
  val Height = 600

  var rayCount = 0
  var hitCount = 0
  var lightCount = 0
  var darkCount = 0

  def main(args: Array[String]): Unit = {
    if (args.length != 2) {
      println("usage: scala Trace input.dat output.png")
      System.exit(-1)
    }

    val (infile, outfile) = (args(0),args(1))
    val scene = Scene.fromFile(infile)

    render(scene, outfile, Width, Height)

    // println("rays cast " + rayCount)
    // println("rays hit " + hitCount)
    // println("light " + lightCount)
    // println("dark " + darkCount)
  }

  def render(scene: Scene, outfile: String, width: Int, height: Int) = {
    val image = new Image(width, height)

    // Init the coordinator -- must be done before starting it.
    Coordinator.init(image, outfile)
    Coordinator.start

    scene.traceImage(width, height)
  }

  // messages to Coordinator
  case class Set(x: Int, y: Int, color: Color)

  object Coordinator extends Actor {
    // Number of pixels we're waiting for to be set.
    var waiting = 0
    var outfile: String = null
    var image: Image = null

    def init(im: Image, of: String) = {
      image = im
      println("setting image to " + image)
      outfile = of
      waiting = im.width * im.height
    }

    def act {
      loop {
        react {
          case Set(x, y, c) => {
            image(x,y) = c
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

  object Color {
    val black = Color(0,0,0)
    val red = Color(1,0,0)
    val green = Color(0,1,0)
    val blue = Color(0,0,1)
    val magenta = red + blue
    val cyan = green + blue
    val yellow = red + green
    val white = red + green + blue

    def fromRGB(x: Int) = {
      val a = (x >>> 24) & 255
      val r = (x >>> 16) & 255
      val g = (x >>> 8) & 255
      val b = x & 255
      Color(r, g, b)
    }
  }

  case class Color(r: Float, g: Float, b: Float) {
    def rgbTuple = (up(r), up(g), up(b))

    private def up(x: Float) = (x * 256).toInt max 0 min 255

    def rgb = {
      val (r,g,b) = rgbTuple
      (r << 16) | (g << 8) | b
    }
    def +(c: Color) = Color(r+c.r, g+c.g, b+c.b)
    def -(c: Color) = Color(r-c.r, g-c.g, b-c.b)
    def *(a: Float) = Color(r*a, g*a, b*a)
    def /(a: Float) = Color(r/a, g/a, b/a)

    def mix(c: Color) = Color(
      (r * c.r),
      (g * c.g),
      (b * c.b))
  }

  object Vector {
    val origin = Vector(0,0,0)
    val x = Vector(1,0,0)
    val y = Vector(0,1,0)
    val z = Vector(0,0,1)
  }

  case class Matrix(row0: Vector, row1: Vector, row2: Vector) {
    def col0 = Vector(row0.x, row1.x, row2.x)
    def col1 = Vector(row0.y, row1.y, row2.y)
    def col2 = Vector(row0.z, row1.z, row2.z)
    def *(v: Vector) = Vector(row0 dot v, row1 dot v, row2 dot v)

    def +(M: Matrix) =
      Matrix(row0 + M.row0, row1 + M.row1, row2 + M.row2)

    def *(M: Matrix) =
      Matrix(Vector(row0 dot M.col0,
        row0 dot M.col1,
        row0 dot M.col2),
        Vector(row1 dot M.col0,
          row1 dot M.col1,
          row1 dot M.col2),
        Vector(row2 dot M.col0,
          row2 dot M.col1,
          row2 dot M.col2))
  }

  case class Vector(x: Float, y: Float, z: Float) {
    def +(v: Vector) = Vector(x+v.x, y+v.y, z+v.z)
    def -(v: Vector) = Vector(x-v.x, y-v.y, z-v.z)
    def *(a: Float) = Vector(x*a, y*a, z*a)
    def /(a: Float) = Vector(x/a, y/a, z/a)
    def unary_- = Vector(-x, -y, -z)

    def cross(v: Vector) =
      Vector(y * v.z - z * v.y,
        z * v.x - x * v.z,
        x * v.y - y * v.x)

    def dot(v: Vector) = x*v.x + y*v.y + z*v.z
    def normSquared: Float = dot(this)

    // Get the 2-norm (i.e., the length)
    def norm: Float = math.sqrt(normSquared).toFloat

    // Normalize so length is 1.
    def normalized = this / norm
  }

  class Image(val width: Int, val height: Int) {
    val im = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)

    def apply(x: Int, y: Int) = Color.fromRGB(im.getRGB(x, y))
    def update(x: Int, y: Int, c: Color) = { im.setRGB(x, y, c.rgb) }

    def print(file: String) = {
      val f = new File(file)
      ImageIO.write(im, "png", f)
    }
  }

  sealed trait Shape {
    def normal(v: Vector): Vector
    def intersect(ray: Ray): List[Vector]
    def shine: Float
    def reflect: Float = shine
    def specular: Float = shine
    def color: Color
  }

  case class Sphere(val center: Vector, val radius: Float, val color: Color, val shine: Float) extends Shape {

    // normal vector at point v on surface of the sphere
    def normal(v: Vector): Vector = (v - center).normalized

    def intersect(ray: Ray): List[Vector] = {
      // vector to the center
      val vc = center - ray.orig

      // The ray is ray.orig + t * ray.dir
      // We want to solve for t to compute the intersections.

      // coefficients of the quadratic equation for t
      val A = ray.dir.normSquared
      val B = 2.0f * (ray.dir dot vc)
      val C = vc.normSquared - radius*radius

      val disc = B*B - 4.0f * A * C

      if (disc < 0)
        return Nil

      val d = math.sqrt(disc)

      val t0 = (-B + d) / (2. * A)
      val t1 = (-B - d) / (2. * A)

      val p0 = ray.orig + ray.dir * t0
      val p1 = ray.orig + ray.dir * t1

      List(p0, p1)
    }
  }

  case class Ray(orig: Vector, dir: Vector)
  case class Light(loc: Vector, color: Color) {
    def brightness = 1.f
  }

  object Scene {
    import java.io._

    def fromFile(file: String) = {
      val in = new LineNumberReader(new FileReader(file))
      val (objects, lights) = readLines(in, Nil, Nil)
      new Scene(objects, lights)
    }

    @annotation.tailrec
    private def readLines(in: LineNumberReader, objects: List[Shape], lights: List[Light]): (List[Shape], List[Light]) = {
      val line = in.readLine
      if (line == null) {
        (objects, lights) match {
          case (Nil, _) => throw new RuntimeException("no objects")
          case (_, Nil) => throw new RuntimeException("no lights")
          case (os, ls) => (os.reverse, ls.reverse)
        }
      }
      else {
        val fields = line.replaceAll("#.*", "").trim.split("\\s+").filter(_!="")
        fields.headOption match {
          case Some("sphere") =>
            val Array(x,y,z,rad,r,g,b,shine) = fields.tail.map(_.toFloat)
            readLines(in, Sphere(Vector(x,y,z), rad, Color(r,g,b), shine) :: objects, lights)
          case Some("light") =>
            val Array(x,y,z,r,g,b) = fields.tail.map(_.toFloat)
            readLines(in, objects, Light(Vector(x,y,z), Color(r,g,b)) :: lights)
          case None =>
            // blank line
            readLines(in, objects, lights)
          case Some(x) =>
            throw new RuntimeException("unknown command: " + x)
        }
      }
    }
  }

  class Scene private (val objects: List[Shape], val lights: List[Light]) {
    private def this(p: (List[Shape], List[Light])) = this(p._1, p._2)

    val ambient = 0f
    val background = Color.black

    val eye = Vector.origin
    val angle = 90f // viewing angle
    // val angle = 180f // fisheye

    def traceImage(width: Int, height: Int) {

      val frustum = (.5 * angle * math.Pi / 180).toFloat

      val cosf = math.cos(frustum)
      val sinf = math.sin(frustum)

      // Anti-aliasing parameter -- divide each pixel into subpixels and
      // average the results to get smoother images.
      val ss = AntiAliasingFactor

      // TODO:
      // Parallelize this loop, creating one actor per pixel or per row of
      // pixels.  Each actor should send the Coordinator messages to set the
      // color of a pixel.  The actor need not receive any messages.
      for (y <- 0 until height) {
        // Make each row an actor
        val tracer = actor {
          for (x <- 0 until width) {

            // This loop body can be sequential.
            var color = Color.black

            for (dx <- 0 until ss) {
              for (dy <- 0 until ss) {

                // Create a vector to the pixel on the view plane formed when
                // the eye is at the origin and the normal is the Z-axis.
                val dir = Vector(
                  (sinf * 2 * ( (x + dx.toFloat / ss) / width - .5 )).toFloat,
                  (sinf * 2 * (height.toFloat / width) * ( .5 - (y + dy.toFloat / ss) / height )).toFloat,
                  cosf.toFloat ).normalized

                /*
                if ((x == 0 && dx == 0 || x == width-1 && dx == ss-1) &&
                    (y == 0 && dy == 0 || y == height-1 && dy == ss-1))
                  println((x,y) + " " + dir)
                  */

                val c = trace(Ray(eye, dir)) / (ss * ss)
                color += c
              }
            }

            if (Vector(color.r, color.g, color.b).norm < 1)
              darkCount += 1
            if (Vector(color.r, color.g, color.b).norm > 1)
              lightCount += 1

            Coordinator ! Set(x, y, color)
          }
        }
        tracer.start
      }
    }

    def shadow(ray: Ray, l: Light): Boolean = {
      val distSquared = (l.loc - ray.orig).normSquared
      intersections(ray).foreach {
        case (v,o) =>
          if ((v - ray.orig).normSquared < distSquared)
            return true
      }
      false
    }

    // Compute the color contributed by light l at point v on object o.
    def shade(ray: Ray, l: Light, v: Vector, o: Shape): Color = {
      val toLight = Ray(v, (l.loc - v).normalized)

      val N = o.normal(v)

      // Diffuse light
      if (shadow(toLight, l) || (N dot toLight.dir) < 0)
        Color.black
      else {
        // diffuse light
        val diffuse = o.color * (N dot toLight.dir)

        // println("ray " + ray)
        // println("diffuse " + diffuse)

        // specular light
        val R = reflected(-toLight.dir, N)
        val len = ray.dir.norm * R.norm

        val specular = if (len > 1e-12) {
          // Want the angle between R and the vector TO the eye

          val cosalpha = -(ray.dir dot R) / len

          val power = if (cosalpha > 1e-12) math.pow(cosalpha, o.shine).toFloat else 0.0f

          if (power > 1e-12) {
            val scale = o.reflect * power
            l.color * o.specular * scale
          }
          else
            Color.black
        }
        else
          Color.black

        // println("specular " + specular)

        val color = diffuse + specular

        // println("color " + color + " 0x" + color.rgb.toHexString)

        color
      }
    }

    def reflected(v: Vector, N: Vector): Vector = v - (N * 2.f * (v dot N))

    def intersections(ray: Ray) = objects.flatMap {
      o => o.intersect(ray).map { v => (v,o) }
    }

    def closestIntersection(ray: Ray) = intersections(ray).sortWith {
      case ((v1,o1), (v2,o2)) => {
        val q1 = (v1 - ray.orig).normSquared
        val q2 = (v2 - ray.orig).normSquared
        q1 < q2
      }
    }.headOption

    val maxDepth = 3

    def trace(ray: Ray): Color = trace(ray, maxDepth)

    private def trace(ray: Ray, depth: Int): Color = {
      rayCount += 1

      // Compute the intersections of the ray with every object, sort by
      // distance from the ray's origin and pick the closest to the origin.
      val r = closestIntersection(ray)

      r match {
        case None => {
          // If no intersection, the color is black
          background
        }
        case Some((v,o)) => {
          // Compute the color as the sum of:

          hitCount += 1

          // The contribution of each point light source.
          var c = lights.foldLeft(Color.black) {
            case (c,l) => c + shade(ray, l, v, o)
          }

          // The contribution of the ambient light.
          c += o.color * ambient

          // Return the color.
          c
        }
      }
    }
  }
}