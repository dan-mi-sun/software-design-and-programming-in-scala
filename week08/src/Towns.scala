object Towns extends App {

  val townsAndCounties = Map(
    "Essex" -> "Chelmsford",
    "Yorkshire" -> "Leeds",
    "Lancashire" -> "Madchester",
    "Devon" -> "Exeter"
  )

  println("Towns in Counties:")
  println("Essex: " + townsAndCounties.get("Essex").getOrElse("Oops"))
  println("Yorkshire: " + townsAndCounties.get("Yorkshire").getOrElse("Oops"))
  println("Kent: " + townsAndCounties.get("Kent").getOrElse("Oops"))
}
