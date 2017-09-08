
// Here is a simple if block that prints a notice if the Boolean expression is true:
if ( 47 % 3 > 0 ) println("Not a multiple of 3")

// If the Boolean expression returns false, what do you expect the if block to return?

val result = if ( false ) "what does this return?"

// Using if/else as expressions
val numer: Double = 22
val denom: Double = 7
val PI = if (denom != 0) {numer/denom} else {None}

// Match expressions

val x = 10
val y = 20

val max = x > y match {
  case true => x
  case false => y
}

// multiple expressions

val status = 500
val message = status match {
  case 200 => "ok"
  case 400 => { println("ERROR - we called the service incorrectly")
                "error" }
  case 500 => { println("ERROR - the service encountered an error")
                "error"}
}


// pattern alternatives

val day = "MON"

val kind = day match {
  case "MON" | "TUE" | "WED" | "THU" | "FRI" => "weekday"
  case "SAT" | "SUN" => "weekend"
}


// value binding pattern

val message = "Ok"
val status = message match {
  case "Ok" => 200
  case other => {
    println(s"Couldn't parse $other")
    -1
  }
}



// catch-all/wildcard matching

val message = "Unauthorized"
val status = message match {
case "Ok" => 200
case _ => {
            println(s"Couldn't parse $message")
            -1
  }
}


// pattern guard
val response: String = null
response match {
case s if s != null => println(s"Received '$s'")
case s => println("Error! Received a null response")
}


// type matching
val x: Int = 12180
val y: Any = x
y match {
  case x: String => s"'x'"
  case x: Double => f"$x%.2f"
  case x: Float => f"$x%.2f"
  case x: Long => s"${x}l"
  case x: Int => s"${x}i"
}



// for loop - old school
val weekDays1 = List("Mon","Tue","Wed","Thu","Fri")
for (day <- weekDays1) {
  println(day)
}


// for-comprehension
val weekDays2 = List("Mon","Tue","Wed","Thu","Fri")
val manicWeekDays = for (day <- weekDays2) yield {
  day match {
    case "Mon" => "Just another Manic Monday"
    case otherDay => otherDay
  }
}



// iterator guards

val threes = for (i <- 1 to 20 if i % 3 == 0) yield i

val quote = "Faith,Hope,,Charity"
for {
  t <- quote.split(",")
  if t != null
  if t.size > 0
} { println(t) }



// nested iterators
for { x <- 1 to 2
      y <- 1 to 3 }
{ print(s"($x,$y) ") }

// value binding
val powersOf2 = for (i <- 0 to 8; pow = 1 << i) yield pow


// while and do/while loops

var alpha = 10;
while (alpha > 0)
  {
    println(alpha)
    alpha -= 1
  }

// The “do/while” loop is similar but the statement is executed before the Boolean expression is first evaluated.

val beta = 0
do
  println(s"Here I am, x = $beta")
while (beta > 0)