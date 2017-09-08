/**
  * Created by Neo on 26/08/2017.
  */


package org.scalaessentials

import org.scalatest.{FunSpec, Matchers}

import scala.annotation.tailrec
import scala.util.matching.Regex
import scala.util.matching.Regex.MatchIterator

class AboutImplicits  extends FunSpec with Matchers {

  describe("""Simple implicits""".stripMargin) {

    it(
      """
        | implicit variables
      """.stripMargin) {

      def greet(implicit greeting: String, code: Int) = s"$greeting, 00$code!"

      implicit val code = 7
      implicit val greeting = "Hello"

      greet should be ("Hello, 007!")

    }

    it(
      """
        | what if both are of same type
      """.stripMargin) {
      def greet(implicit greeting: String, name: String) = s"$greeting, $name!"
      implicit val greeting = "Hello"
      implicit val name = "Mr. Bond"
      "greet" shouldNot compile
      //assertDoesNotCompile(greet) -- this is failling in the latest (3.0.X) build of scalatest #855

    }

    it(
      """
        | and, lastly the case for implicit conversions
      """.stripMargin) {
      implicit def agentCodename(i: Int) = s"00$i"
      def hello(name: String) = s"Hello, $name!"
      hello(7) should be ("Hello, 007!")
    }

    it(
      """
        | this applies to class as well
      """.stripMargin) {
      implicit class Agent(code: Int) {
        def codename = s"00$code"
      }
      def hello(agent: Agent) = s"Hello, ${agent.codename}!"
      hello(7) should be ("Hello, 007!")
    }
  }

  describe("""bindings""") {

    it(
      """
        | ex1
      """.stripMargin) {


      object Wildcard {
        def x = "Wildcard Import x"
      }

      object Explicit {
        def x = "Explicit Import x"
      }

      def testWildcardImport(): String = {
        import Wildcard._
        x
      }

      def testExplicitImport(): String = {
        import Explicit.x
        import Wildcard._
        x
      }

      def testInlineDefinition(): String = {
        val x = "Inline definition x"
        import Explicit.x
        import Wildcard._
        x
      }

      //"testSamePackage" shouldNot compile

      testInlineDefinition should be ("Inline definition x")
      testExplicitImport should be ("Explicit Import x")
      testWildcardImport should be ("Wildcard Import x")
      "x" shouldNot compile

    }

  }


  describe("""implicit resolutions""") {

  }

  describe("""implicit conversions""") {
    it("simple case") {
      case class A(x: Int)
      case class B(m:String, v:Double) {
        def beep = println(s"You have a message $m, it will cost $v to access it.")
      }

      implicit def conv(v: A): B = B("Some String", v.x.toDouble)
      def f(x: B): Double = x.m.size * x.v

      val k: B = A(5)
      val n: A = A(3)
      val m1: String = n.m
      val v1: Double = n.v
      val f1: Double = f(n)

      k should be (B("Some String", 5.0))
      m1 should be ("Some String")
      v1 should be (3.0)
      f1 should be (33.0)
    }


  }

  describe("""implicit parameters""") {
    it("simple case") {
      def f(implicit x: Int) = x*2
      //f can be used as any other function ...
      val res = f(42)   //.. and receive  'x' explicitly
      //Or, with an implicit 'Int' in context, ...
      implicit val v: Int = 42 //Implicit value (implicit actual param)
      // Be called without any actual parameter:
      val resb = f

      resb should be (res)
    }

    it("slightly involved case") {

      //from last test
      implicit val v: Int = 42 //Implicit value (implicit actual param)

      def g(x: Int, y: Int)(implicit base: Int): Int = (x+y)%base
      //g(41,1) Will return 0, (41+1)%42, but ...
      //g(41,1)(100) will return 42 because of the higher value for 'base'

      g(41,1) should be (0)
      g(41,1)(100) should be (42)
    }
  }

  describe("""Implicit Conversions and Implicit Parameters: Two sides of the same coin""") {
    it("simple case") {
      case class B(x: Int)
      case class A(x: String)
      implicit val a2b  = (v: A) => B(v.x.toInt)
      val b: B = A("12")
      b should be (B(12))

      /* Note ::
      | And, as expected, that would work. Implicit conversions are functions, therefore values.
      | On the other hand, actual implicit parameters (the ones used to complete incomplete function calls)
      | are just that: values.
       */
    }

    describe("""Implicit context""") {
      /*
      The implicit context at a given point of your source code is the set of implicit values available for the
      compiler to perform type conversions or complete function calls when that point of code is providing an
      unexpected type object or missing some parameter in a function call.
       */
      it("simple case") {

        {
          def f(implicit a: Int, b: String): String = (s"a=$a\tb=$b")

          implicit val x: Int = 3;
          implicit val y: String = "humans";
          {
            val first: String = f;
            first should be("a=3\tb=humans");
            {
              implicit val y: String = "dolphins"
              val second = f;
              second should be("a=3\tb=dolphins")
            }
          }
          val third = f;
          third should be("a=3\tb=humans")
        }
      }

        it("ambiguous implicit values") {

          {
            def f(implicit a: Int, b: String): String = (s"a=$a\tb=$b")
            implicit val x: Int = 3;
            implicit val y: String = "humans";
            {
              val first: String = f;
              first should be ("a=3\tb=humans");
              {
                //implicit val z: String = "dolphins"
                implicit val y: String = "dolphins"

                val second = f;
                second should be ("a=3\tb=dolphins")
                //second shouldNot compile;
              }
            }
            val third = f;
            third should be ("a=3\tb=humans")
          }
      }

      it("implicit parameters") {
        def f(implicit x: Int): String = (
          s"Implicit value for integers within f's body: ${implicitly[Int]}"
        )
        f(3) should be ("Implicit value for integers within f's body: 3")
        implicit val vOutsideF = 42
        f should be ("Implicit value for integers within f's body: 42")
      }

      it("companion object of the target class") {

        object B { //B class companion object
          implicit def fromA(o: A): B = B(o.x.toDouble)
        }

        case class A(x: Int);
        case class B(y: Double);

        val b: B = A(3)
        b.y should be (3.0)

      }

      it("companion object of the source classs") {
        object A { //A class companion object
          implicit def toB(o: A): B = B(o.x.toDouble)
        }

        case class A(x: Int)
        case class B(y: Double)

        val b: B = A(3)
        b.y should be (3.0)
      }
    }
  }


}
