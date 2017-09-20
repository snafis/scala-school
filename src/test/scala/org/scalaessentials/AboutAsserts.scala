package org.scalaessentials

import org.scalatest.{FunSpec, Matchers}

// meditate on AboutAsserts to see how the Scala describes work
class AboutAsserts extends FunSpec with Matchers {

  describe("asserts can take a boolean argument") {
    assert(true) // should be true
  }

  describe("asserts can include a message") {
    assert(true, "This should be true")
  }

  describe("true and false values can be compared with should matchers") {
    true should be(true) // should be true
  }

  describe("booleans in asserts can test equality") {
    val v1 = 4
    val v2 = 4
    assert(v1 === v2)
  }

  describe("sometimes we expect you to fill in the values") {
    assert(2 == 1 + 1)
  }
}
