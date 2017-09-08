package org.scalaessentials

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.{FunSpec, Matchers}

class AboutConstructors extends FunSpec with Matchers {

  class AboutConstructorWithValParameter(val name: String) {
    // invoke auxilary constructor
    def this() {
      // what happens if you comment out the following line?
      this ("defaultname")
    }
  }

  class AboutClassWithNoClassParameter {
  }

  class AboutConstructorWithVarParameter(var name: String) {
  }

  class AboutConstructorWithPrivateClassParameter(name: String) {
  }

  describe("val in class definition defines read only property") {
    val aboutMe = new AboutConstructorWithValParameter("MyName")
    aboutMe.name should be("MyName")
  }

  describe("var in class definition defines read/write parameters") {
    val aboutMe = new AboutConstructorWithVarParameter("MyName")
    aboutMe.name = "YourName"
    aboutMe.name should be("YourName")
  }

  describe("private member data is not accessible") {
    val aboutMe = new AboutConstructorWithPrivateClassParameter("MyName")

    // what happens if you uncomment this line? why?
    // aboutMe.name = "Me"
  }

  describe("Primary constructor specified with a parameter requires that parameter to be passed in") {
    // val aboutMe = new AboutConstructorWithValParameter()
  }

  describe("Class with no class parameters is called with no arguments") {
    // add parameter to make this fail
    val aboutMe = new AboutClassWithNoClassParameter
  }
}
