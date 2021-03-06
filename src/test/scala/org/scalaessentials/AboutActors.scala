package org.scalaessentials

import org.scalatest.{FunSpec, Matchers}

class AboutActors extends FunSpec with Matchers {
  describe("Basic Actor that extends Actor, this will ben invoked in separate thread") {
    class AbrahamLincoln extends Actor {
      def act() {
        println("Four score and seven years ago.")
      }
    }

    val abe = new AbrahamLincoln
    abe.start()
  }

  describe("Basic anonymous actor") {
    val jfk = actor {
      println("Ask not what your country can do for you")
    }
  }

  describe("""Messages can be sent to actors. The ! calls are inspired by Erlang
        | React method returns no result""") {
    val guessNumber = actor {
      loop {
        react {
          case i: Int if (i > 64) => println("Too high")
          case i: Int if (i < 64) => println("Too low")
          case i: Int if (i == 64) => {
            println("Ding!")
            exit('successful)
          }
          case _ => println("You gave me something wrong")
        }
      }
    }

    guessNumber ! 20
    guessNumber ! 23
    guessNumber ! 90
    guessNumber ! 75
    guessNumber ! 70
    guessNumber ! 61
    guessNumber ! "Boing"
    guessNumber ! 65.34
    guessNumber ! 64

    Thread.sleep(1000)
  }

  describe("""case _ => is used as a catch all, if you do not adequately cover all possible scenarios, messages
          will be held in an actors mail box.""") {
    println("---------")
    val guessNumber = actor {
      loop {
        react {
          case i: Int if (i > 64) => println("Too high")
          case i: Int if (i < 64) => println("Too low")
          case i: Int if (i == 64) => {
            println("Ding!")
            println(mailboxSize + " messages have not been matched")
            exit('successful)
          }
        }
      }
    }

    guessNumber ! 20
    guessNumber ! 23
    guessNumber ! "Boing"
    guessNumber ! 90
    guessNumber ! 75
    guessNumber ! 70
    guessNumber ! 61
    guessNumber ! 64
    guessNumber ! "Boom"
    guessNumber ! 65.34
    Thread.sleep(1000)
  }

  describe("""Up until now we have been Actors the way it wasn't intended.  Actors are intended
          to communicate back and forth by message passing using the ! operator.
          self is to reference the current Actor.""") {

    println("---------")
    val guessNumber = actor {
      loop {
        react {
          case (i: Int, caller: Actor) if (i > 64) => caller ! "Too High"
          case (i: Int, caller: Actor) if (i < 64) => caller ! "Too Low"
          case (i: Int, caller: Actor) if (i == 64) => {
            caller ! "Ding"
            exit('successful)
          }
        }
      }
    }

    val items = List(20, 23, "Boing", 90, 75, 70, 61, 64, "Boom", 65.34)
    items.foreach {
      x =>
        guessNumber ! (x, self)
        self.receiveWithin(100) {
          case "Too High" => println("Too High")
          case "Too Low" => println("Too Low")
          case "Ding" => println("Just Right")
          case _ => println("Timed Out")
        }
    }

    Thread.sleep(1000) //Wait until all of it is completely done.
  }
}