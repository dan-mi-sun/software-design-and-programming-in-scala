package scalatraitsorig

import java.util.Date

case class Anonymous(id: String, createdAt: Date = new Date())

case class User(id: String, email: String, createdAt: Date = new Date())