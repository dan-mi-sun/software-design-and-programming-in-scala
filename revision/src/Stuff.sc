var xs:Seq[Int] = List(1,3,5,6,8)
xs filter (x => x > 5)
xs filter (x => !(x > 5))
xs partition (x => x > 5)
xs take 3
xs drop 3
def f(x: Int, y: Int) = { x + y}
f(3,4)

def ff(x: Int)(y:Int) = x + y

ff(3)(4)

val x = ff(3)_
x
x(4)
x(5)

