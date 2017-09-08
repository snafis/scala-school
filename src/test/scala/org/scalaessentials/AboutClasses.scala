package org.scalaessentials

import org.scalatest.matchers.ShouldMatchers
import support.BlankValues.__
import org.scalatest.{FunSpec, Matchers}

class AboutClasses extends FunSpec with Matchers {


  // you can define class with var or val parameters
  class ClassWithVarParameter(var description: String) {

  }

  describe("val parameters in class definition define getter") {
    val aClass = new ClassWithValParameter("name goes here")
    aClass.name should be("name goes here");
  }

  class ClassWithValParameter(val name: String) {

  }

  describe("var parameters in class definition define getter and setter") {
    val aClass = new ClassWithVarParameter("description goes here")
    aClass.description should be("description goes here");

    aClass.description = "new description"
    aClass.description should be("new description")
  }

  // you can define class with private fields
  class ClassWithPrivateFields(name: String) {

  }

  describe("fields defined internally are private to class") {
    val aClass = new ClassWithPrivateFields("name")

    // NOTE: aClass.name is not accessible
  }

}