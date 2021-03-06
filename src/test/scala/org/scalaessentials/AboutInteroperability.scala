package org.scalaessentials

import org.scalatest.{FunSpec, Matchers}


class AboutInteroperability extends FunSpec with Matchers {
  describe("""You can interop with a java class and it's use of collections by importing
          |   scala.collection.JavaConversions and letting scala implicitly convert from a Scala collection type
          |   into a Java collection type.  See AboutImplicits describe Suite for more details and see src/test/java for the
          |   SomeJavaClass file. This describe
          |   converts a scala List of String to java List of raw type.""") {
    val d = new SomeJavaClass
    val e = List("one", "two", "three")
    d.findSizeOfRawType(e) should be(3)
  }

  class Boat(size: Int, manufacturer: String)

  describe("""This describe converts a scala List of Boat (our own class) to java List of unknown <?> type.""") {
    val d = new SomeJavaClass
    val e = List(new Boat(33, "Skyway"), new Boat(35, "New Boat"))
    d.findSizeOfUnknownType(e) should be(2)
  }
}