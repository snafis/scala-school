package org.scalaessentials

import org.scalatest.{FunSpec, Matchers}
import scala.collection.mutable

class AboutMutableMaps extends FunSpec with Matchers {

  describe("Mutable maps can be created easily") {
    val myMap = mutable.Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "IA" -> "Iowa")
    myMap.size should be(4)
    myMap += "OR" -> "Oregon"
    myMap contains "OR" should be(true)
  }

  describe("Mutable maps can have elements removed") {
    val myMap = mutable.Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "IA" -> "Iowa")
    myMap -= "OH"
    myMap contains "OH" should be(false)
  }

  describe("Mutable maps can have tuples of elements removed") {
    val myMap = mutable.Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "IA" -> "Iowa")
    myMap -= ("IA", "OH")
    myMap contains "OH" should be(false)
    myMap.size should be(2)
  }

  describe("Mutable maps can have tuples of elements added") {
    val myMap = mutable.Map("MI" -> "Michigan", "WI" -> "Wisconsin")
    myMap += ("IA" -> "Iowa", "OH" -> "Ohio")
    myMap contains "OH" should be(true)
    myMap.size should be(4)
  }

  describe("Mutable maps can have Lists of elements added") {
    val myMap = mutable.Map("MI" -> "Michigan", "WI" -> "Wisconsin")
    myMap ++= List("IA" -> "Iowa", "OH" -> "Ohio")
    myMap contains "OH" should be(true)
    myMap.size should be(4)
  }

  describe("Mutable maps can have Lists of elements removed") {
    val myMap = mutable.Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "IA" -> "Iowa")
    myMap --= List("IA", "OH")
    myMap contains "OH" should be(false)
    myMap.size should be(2)
  }

  describe("Mutable maps can be cleared") {
    val myMap = mutable.Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "IA" -> "Iowa")
    myMap.clear() // Convention is to use parens if possible when method called changes state
    myMap contains "OH" should be(false)
    myMap.size should be(0)
  }

}