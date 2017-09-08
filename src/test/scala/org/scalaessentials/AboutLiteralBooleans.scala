package org.scalaessentials

import org.scalatest.{FunSpec, Matchers}

class AboutLiteralBooleans extends FunSpec with Matchers {

  describe("""Boolean literals are either true or false, using the true or false keyword""") {
    val a = true
    val b = false
    val c = 1 > 2
    val d = 1 < 2
    val e = a == c
    val f = b == d
    a should be(true)
    b should be(false)
    c should be(false)
    d should be(true)
    e should be(false)
    f should be(false)
  }

}