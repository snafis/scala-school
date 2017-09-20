package org.scalaessentials

import org.scalatest.{FunSpec, Matchers}

class AboutForExpressions extends FunSpec with Matchers {

  describe("For loops can be simple") {
    val someNumbers = Range(0, 10)
    var sum = 0
    for (i <- someNumbers)
      sum += i

    sum should equal(45)
  }

  describe("For loops can contain additional logic") {
    val someNumbers = Range(0, 10)
    var sum = 0
    // sum only the even numbers
    for (i <- someNumbers)
      if (i % 2 == 0) sum += i

    sum should equal(20)
  }
  describe("For loops can produce a list which can be summed easily") {
    val someNumbers = Range(0, 10)

    val theList =
      for {
        i <- someNumbers
        if ((i % 2) == 0)
      }
      yield i

    theList.reduceLeft(_ + _) should be(20)
  }

  describe("For expressions can nest, with later generators varying more rapidly than earlier ones") {
    val xValues = Range(1, 5)
    val yValues = Range(1, 3)
    val coordinates = for {
      x <- xValues
      y <- yValues
    }
    yield (x, y)
    coordinates(4) should be(3, 1)
  }


}
