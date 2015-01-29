package guice

class UserDAO extends UserDAOComponent {
  // a dummy data access layer
  def getUser(id: String): User = {
    val user = User("12334", "testUser", "fred@apple.com")
    println("UserDAO: Getting user " + user)
    user
  }

  def create(user: User) = {
    println("UserDAO: creating user: " + user)
  }

  def delete(user: User) = {
    println("UserDAO: deleting user: " + user)
  }
}
