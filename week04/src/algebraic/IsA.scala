package algebraic

// if Aa is a Ba or Ca

sealed trait Aa 
final case class Ba() extends Aa
final case class Ca() extends Aa


// =========================== Is-a OR pattern SUM type

/*
        AND               OR
IS-A    Cake              Sum type
HAS-A   Product type      ???
*/

// Aaa is a Baa and Caa

trait Baa
trait Caa
trait Aaa extends Baa with Caa // with xxx

// Cake Pattern

// "has-a or" pattern
// A has a B or C
// A has a d of type D, where D is B or C

trait Ax {
  def d: D
}

sealed trait D
final case class Bx() extends D
final case class Cx() extends D

// A is a D or E -> D has a B and E has C

sealed trait Axx
final case class Dx(b: Baa) extends Axx
final case class Ex(c: Caa) extends Axx
