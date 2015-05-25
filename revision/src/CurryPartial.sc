// curry

def line(a: Int, b: Int, x: Int): Int = a * x + b

def curriedLine(a: Int)(b: Int)(x: Int): Int = line(a, b, x)

def defaultLine(x: Int): Int = curriedLine(1)(0)(x)

// def curriedLine = (line _).curried

defaultLine(5) // returns `5`


// partial - essentially the same but freezes the value and works with multiple args

def partialLine = (b: Int, x: Int) => line(2, b, x)

partialLine(0, 1)

// def partialLine = line(2, _: Int, _: Int)


