package org.functionaldescribes.forscala

import org.scalatest.{FunSpec, Matchers}

package harkonnen {

class AlphaBase extends FunSpec with Matchers {
  private val melange = 1
  private[this] val oregano = 2
  private[AlphaBase] val tarragon = 3
  private[harkonnen] val rosemary = 4

  val parsley = 5
  //    public val ginger = 6  //does not exist, in case you were wondering
  //    public[this] val lemongrass = 7   //does not exist, in case you were wondering
  //    public[AlphaBase] val carob = 8   //does not exist, in case you were wondering
  //    public[har] val celerySeed = 9  //does not exist, in case you were wondering

  protected val sage = 10
  protected[this] val paprika = 11
  protected[AlphaBase] val saffron = 12
  protected[harkonnen] val thyme = 13
}


class BetaBase extends AlphaBase with FunSpec with Matchers {
  val param: AlphaBase = new AlphaBase

  describe("With private keywords: Only private[packagename] members can be accessed via inheritance") {
    //melange should be(1) //not accessible
    //oregano should be (2) //not accessible
    //tarragon should be (3) //not accessible
    rosemary should be(4)
  }

  describe("With private keywords: Only private[packagename] members can be accessed via parameter") {
    //param.melange should be (1) //not accessible
    //param.oregano should be (2) //not accessible
    //param.tarragon should be (3) //not accessible
    param.rosemary should be(4)
  }

  describe("With public keywords: All members can be accessed through inheritance") {
    parsley should be(5)
  }

  describe("With public keywords: All members can be accessed can be accessed via parameter") {
    param.parsley should be(5)
  }

  describe("With protected keywords: All members can be accessed via inheritance") {
    sage should be(10)
    paprika should be(11) //not accessible
    saffron should be(12) //not accessible
    thyme should be(13)
  }

  describe("With protected keywords: Only private[packagename] members can be accessed via parameter") {
    //param.sage should be (10) //not accessible
    //param.paprika should be (11) //not accessible
    //param.saffron should be (12) //not accessible
    param.thyme should be(13)
  }
}

class GammaBase extends FunSpec with Matchers {

  val param: AlphaBase = new AlphaBase

  describe("With private keywords: No members can be accessed via inheritance") {
    //melange should be(1) //not accessible
    //oregano should be (2) //not accessible
    //tarragon should be (3) //not accessible
    //rosemary should be(4)  //not accessible
  }

  describe("With private keywords: Only private[packagename] members can be accessed via parameter") {
    //param.melange should be (1) //not accessible
    //param.oregano should be (2) //not accessible
    //param.tarragon should be (3) //not accessible
    param.rosemary should be(4)
  }

  describe("With public keywords: All members can be accessed through inheritance") {
    //parsley should be(5)  //not accessible
  }

  describe("With public keywords: All members can be accessed can be accessed via parameter") {
    param.parsley should be(5)
  }

  describe("With protected keywords: All members can be accessed via inheritance") {
    //sage should be (10)
    //paprika should be (11) //not accessible
    //saffron should be (12) //not accessible
    //thyme should be (13)
  }

  describe("With protected keywords: Only private[packagename] members can be accessed via parameter") {
    //    param.sage should be (10) //not accessible
    //    param.paprika should be (11) //not accessible
    //    param.saffron should be (12) //not accessible
    param.thyme should be(13)
  }
}

}

package atreides {

import org.functionaldescribes.forscala.harkonnen.AlphaBase

class DeltaBase extends AlphaBase with describeSuite with ShouldMatchers {
  val param: AlphaBase = new AlphaBase

  describe("With private keywords: Only private and private[packagename] members can be accessed via inheritance") {
    //melange should be (1)
    //oregano should be (2) //not accessible
    //tarragon should be (3) //not accessible
    //rosemary should be (4)
  }

  describe("With private keywords: Only private[packagename] members can be accessed via parameter") {
    //    param.melange should be (1) //not accessible
    //    param.oregano should be (2) //not accessible
    //    param.tarragon should be (3) //not accessible
    //    param.rosemary should be(4)  //not accessible
  }

  describe("With public keywords: All members can be accessed through inheritance") {
    parsley should be(5)
  }

  describe("With public keywords: All members can be accessed can be accessed via parameter") {
    param.parsley should be(5)
  }

  describe("With protected keywords: All members can be accessed via inheritance") {
    sage should be(10)
    paprika should be(11) //not accessible
    saffron should be(12) //not accessible
    thyme should be(13)
  }

  describe("With protected keywords: Only private[packagename] members can be accessed via parameter") {
    //param.sage should be (10) //not accessible
    //param.paprika should be (11) //not accessible
    //param.saffron should be (12) //not accessible
    //param.thyme should be (13)
  }
}

class EpsilonBase extends FunSpec with Matchers {
  val param: AlphaBase = new AlphaBase

  describe("With private keywords: Only private and private[packagename] members can be accessed via inheritance") {
    //    melange should be (1) //not accessible
    //    oregano should be (2) //not accessible
    //    tarragon should be (3) //not accessible
    //    rosemary should be (4) //not accessible
  }

  describe("With private keywords: Only private[packagename] members can be accessed via parameter") {
    //    param.melange should be (1) //not accessible
    //    param.oregano should be (2) //not accessible
    //    param.tarragon should be (3) //not accessible
    //    param.rosemary should be(4) //not accessible
  }

  describe("With public keywords: All members can be accessed through inheritance") {
    //    parsley should be(5)
  }

  describe("With public keywords: All members can be accessed can be accessed via parameter") {
    param.parsley should be(5)
  }

  describe("With protected keywords: All members can be accessed via inheritance") {
    //    sage should be (10)
    //    paprika should be (11) //not accessible
    //    saffron should be (12) //not accessible
    //    thyme should be (13)
  }

  describe("With protected keywords: Only private[packagename] members can be accessed via parameter") {
    //    param.sage should be (10) //not accessible
    //    param.paprika should be (11) //not accessible
    //    param.saffron should be (12) //not accessible
    //    param.thyme should be (13)
  }
}

}

class AboutAccessModifiers extends FunSpec with Matchers {

}
