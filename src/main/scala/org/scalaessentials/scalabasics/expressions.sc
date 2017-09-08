
// Expressions Can Be Used as R-values

val weekDays = List("Mon","Tue","Wed","Thu","Fri")

// Expressions Can Be Passed into Functions

println(weekDays.map(_ == "Mon"))

// Expressions Blocks Are Enclosed in {}
val radius = 10  val area = {
  val PI = 3.14;
  PI * radius * radius  }



// Expressions Blocks Can Have Nested Scopes
val area = {
  println(s"Inside scope 1, PI = $PI");
  {
    val PI = 3.14
    println(s"Inside scope 2, PI = $PI")  PI * radius * radius
  }  }