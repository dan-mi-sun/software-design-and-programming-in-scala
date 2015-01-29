package guice

case class User(id: String, name: String, email: String)

object User {
  def apply(id: String, name: String, email: String) =
    new User(id, name, email)
}