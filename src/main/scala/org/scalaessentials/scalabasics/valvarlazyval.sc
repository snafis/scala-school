/*
| val, var and lazy val
 */

// In Scala, ‘val’ is used to define constants.
// It evaluates only once. They are evaluated at the time of definition only.
// Once its evaluated, it reuses same value for all references of it.

// Immutable data can not be changed once define
val number1 = { println("Constant number is initialized."); 99 }
println("Before Accessing 'number' constant:")
println(number1 + 1)
println(number1 + 1)
println(number1 + 1)

// Use mutable data only when absolutely essential
var number2 = { println("Variable number is initialized."); 99 }
println("Before Accessing 'number' variable:")
println(number2 + 1)
println(number2 + 1)
println(number2 + 1)


// Common Collections Are Immutable Too

val someNumbers = collection.immutable.List(10,20,30,40,50,60)
val someSet = collection.immutable.Set("A","B", "C")
val stockCodes = collection.immutable.Map("ACN" -> "Accenture", ("AAPL","APPLE"))


// lazy val

lazy val number = { println("Constant number is initialized."); 99 }
println("Before Accessing 'number' constant:")
println(number + 1)
println(number + 1)
println(number + 1);

// var vs lazy val
val normalVal: String = { println("Initializing normal val"); "This is the normal val" }
lazy val lazyVal: String = { println("Initializing lazy val"); "This is the lazy val" }
println("\n\nno references have been made yet\n\n")
println("Accessing normal val : ")
println(normalVal)
println("\n\nAccessing lazy val : ")
println(lazyVal)
println("\n\nAccessing lazy val a second time, there should be no initialization now: ")
println(lazyVal)