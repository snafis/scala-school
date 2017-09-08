
package org.scalaessentials

import org.scalatest.{FunSpec, Matchers}

class AboutHelloWorld extends FunSpec with Matchers {

  describe("HelloWorld in Scala") {
    it("Hello Scala!") {
      trait Output {
        def print(s: String) = Console.println(s)
      }

      class Hi extends Output {
        def hello() = print("Hello there, Scala!")
      }

      trait MockOutput extends Output {
        var messages: Seq[String] = Seq()

        override def print(s: String) = messages = messages :+ s
      }

      val hi = new Hi with MockOutput
      hi.hello()
      hi.messages should contain("Hello there, Scala!")
    }
  }
}


