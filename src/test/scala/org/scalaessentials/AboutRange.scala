package org.scalaessentials

import org.scalatest.{FunSpec, Matchers}

class AboutRange extends FunSpec with Matchers {

  describe("Range are not inclusive at end of range") {
    val someNumbers = Range(0, 10)

    someNumbers.size should be(10)
  }

  describe("Range can specify increment") {
    val someNumbers = Range(2, 10, 3)

    someNumbers.size should be(3)
  }

  describe("Range can indicate inclusion") {
    val someNumbers = Range(0, 34, 2)
    someNumbers.contains(33) should be(false)
    someNumbers.contains(32) should be(true)
    someNumbers.contains(34) should be(false)
  }

  describe("Range can specify to include value") {
    val someNumbers = Range(0, 34).inclusive

    someNumbers.contains(34) should be(true)
  }

}
