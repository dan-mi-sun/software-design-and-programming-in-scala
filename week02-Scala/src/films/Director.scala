package films

class Director(
  val firstName: String,
  val lastName: String,
  val yearOfBirth: Int) {
  def name: String =
    s"$firstName $lastName"
  //firstName + " " + lastName

  def copy(
    firstName: String = this.firstName,
    lastName: String = this.lastName,
    yearOfBirth: Int = this.yearOfBirth) =
    new Director(firstName, lastName, yearOfBirth)
}