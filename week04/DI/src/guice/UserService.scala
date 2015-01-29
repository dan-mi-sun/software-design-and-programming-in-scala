package guice

import com.google.inject.Inject

@Inject class UserService()(userDAO: UserDAOComponent) {

  def getUserInfo(id: String): User = {
    val user = userDAO.getUser(id)
    println("UserService: Getting user " + user)
    user
  }

  def createUser(user: User) = {
    userDAO.create(user)
    println("UserService: creating user: " + user)
  }

  def deleteUser(user: User) = {
    userDAO.delete(user)
    println("UserService: deleting user: " + user)
  }

}
