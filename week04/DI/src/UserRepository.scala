// a dummy service that is not persisting anything
// solely prints out info - DAO pattern
trait UserRepositoryComponent {
  val userRepository: UserRepository

  class UserRepository {
    def authenticate(user: User): User = {
      println("authenticating user: " + user)
      user
    }

    def authenticate(username: String, password: String): User = {
      authenticate(User(username, password))
    }

    def create(user: User) = println("creating user: " + user)

    def delete(user: User) = println("deleting user: " + user)
  }

}

case class User(username: String, password: String)

object User {
  def apply(username: String, password: String) =
    new User(username, password)
}


trait UserServiceComponent {
  this: UserRepositoryComponent =>
  val userService: UserService

  class UserService {
    def authenticate(username: String, password: String): User =
      userRepository.authenticate(username, password)

    def create(username: String, password: String) =
      userRepository.create(new User(username, password))

    def delete(user: User) = userRepository.delete(user)
  }

}

object ComponentRegistry extends UserServiceComponent with UserRepositoryComponent {
  val userRepository = new UserRepository
  val userService = new UserService
}