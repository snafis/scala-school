package org.scalaessentials

import org.scalatest.{FunSpec, Matchers}


class AboutEmptyValues extends FunSpec with Matchers {

  describe("None equals None") {
    assert(None === None)
  }

  describe("None should be identical to None") {
    val a = None
    assert(a eq None) // note that eq denotes identity, and == denotes equality in Scala
  }

  describe("None can be converted to a String") {
    assert(None.toString === "None")
  }

  describe("An empty list can be represented by another nothing value: Nil") {
    assert(List() === Nil)
  }

  describe("None can be converted to an empty list") {
    val a = None
    assert(a.toList === Nil)
  }

  describe("None is considered empty") {
    assert(None.isEmpty === true)
  }

  /*describe ("None can be cast Any, AnyRef or AnyVal") {
     assert(None.asInstanceOf[Any] === __)
     assert(None.asInstanceOf[AnyRef] === __)
     assert(None.asInstanceOf[AnyVal] === __)
 } */

  describe("None cannot be cast to all types of objects") {
    intercept[ClassCastException] {
      // put the exception you expect to see in place of the blank
      assert(None.asInstanceOf[String] === classOf[ClassCastException])
    }
  }

  describe("None can be used with Option instead of null references") {
    val optional: Option[String] = None
    assert(optional.isEmpty === true)
    assert(optional === None)
  }

  describe("Some is the opposite of None for Option types") {
    val optional: Option[String] = Some("Some Value")
    assert((optional == None) === false, "Some(value) should not equal None")
    assert(optional.isEmpty === false, "Some(value) should not be empty")
  }

  describe("Option.getOrElse can be used to provide a default in the case of None") {
    val optional: Option[String] = Some("Some Value")
    val optional2: Option[String] = None
    assert(optional.getOrElse("No Value") === "Some Value", "Should return the value in the option")
    assert(optional2.getOrElse("No Value") === "No Value", "Should return the specified default value")
  }
}
