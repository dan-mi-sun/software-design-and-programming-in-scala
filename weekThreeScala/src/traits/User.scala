package traits

import java.util.Date

trait Visitor {
  def id: String // unique id assigned to each user
  def createdAt: Date // Date this user first visited the site
  // how long has the visitor been around?
  def age: Long = new Date().getTime - createdAt.getTime
}

case class User(
  id: String,
  email: String,
  createdAt: Date = new Date()) extends Visitor

case class Anonymous(id: String, createdAt: Date = new Date()) extends Visitor

object Test {
  def main(args: Array[String]): Unit = {
    println(older(Anonymous("1"), User("2", "fred@goo")))
  }

  def older(v1: Visitor, v2: Visitor): Boolean =
    v1.createdAt.before(v2.createdAt)

}