val x: List[Int] = List(1,2,3,4,5)

x.last
x.length
x.init
x take 2
x drop 2
x(3)

val y:List[Int] = List(5,3,4,6,1,2)
x ++ y

x reverse

x updated (3,7)

x indexOf(4)
x indexOf 10

x contains 3

def mylast[T](xs: List[T]): T = xs match {
  case List() => throw new Error("last element of empty list!")
  case List(x) => x
  case hd::tl => mylast(tl)
}

mylast(y)

def myconcat[T](xs: List[T], ys: List[T]): List[T] = xs match {
  case List() => ys
  case hd::tl => hd :: myconcat(tl,ys)
}

myconcat(x,y)

def myreverse[T](xs:List[T]): List[T] = xs match {
  case List() => xs // saves on construction
  case hd::tl => myreverse(tl) ++ List(hd)
}

myreverse(y)





