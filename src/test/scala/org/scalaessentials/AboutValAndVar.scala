package org.scalaessentials
import org.scalatest.{FunSpec, Matchers}

class AboutValAndVar extends FunSpec with Matchers {
  describe("Data Is Declared Mutable Using var") {
    it("vars may be reassigned") {
      var a = 5
      a should be(5)

      a = 7
      a should be(7)
    }

    it("vals may not be reassigned") {
      val a = 5
      a should be(5)

      // What happens if you uncomment these lines?
      // a = 7
      // a should be (5)
    }

    it("vals or vars can have the same name as a keyword as long as it's surrounded by `") {
      val `class` = "MyClassName"
      `class` should be("MyClassName")
    }
  }
}