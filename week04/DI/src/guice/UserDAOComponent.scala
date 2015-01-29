package guice

// define a trait for database access object
trait UserDAOComponent {

  def getUser(id: String): User

  def create(user: User)

  def delete(user: User)

}
