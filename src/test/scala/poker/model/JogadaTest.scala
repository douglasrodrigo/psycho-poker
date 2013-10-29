package poker.model

import poker.model._
import org.specs2.mutable._
import poker.model.Jogada._

class JogadaTest extends Specification {

  val maoPair = List(Carta("AC"), Carta("AS"), Carta("3C"), Carta("4S"), Carta("TC"))

  val maoTwoPairs = List(Carta("AC"), Carta("AS"), Carta("4C"), Carta("4S"), Carta("TC"))

  val maoThree = List(Carta("AC"), Carta("AS"), Carta("AD"), Carta("4S"), Carta("TC"))

  val maoFlush = List(Carta("AC"), Carta("3C"), Carta("4C"), Carta("5C"), Carta("TC"))

  val maoFullHouse = List(Carta("AC"), Carta("AD"), Carta("4C"), Carta("4D"), Carta("4S"))

  val maoStraightFlush = List(Carta("2C"), Carta("3C"), Carta("4C"), Carta("5C"), Carta("6C"))

  val maoStraightLowAce = List(Carta("AC"), Carta("2S"), Carta("3C"), Carta("4C"), Carta("5C"))

  val maoStraightNonOrdered = List(Carta("AC"), Carta("2D"), Carta("3S"), Carta("5S"), Carta("4D"))

  val maoHighestCard = List(Carta("AS"), Carta("2C"), Carta("3C"), Carta("5C"), Carta("6C"))

  val maoFour = List(Carta("AS"), Carta("AC"), Carta("AD"), Carta("AH"), Carta("6C"))


  "Jogada jogadaOf" should {

    "reconhecer uma mao de pair" in {
      jogadaOf(maoPair) must be(OnePair)
    }

    "reconhecer uma mao de Two pairs" in {
      jogadaOf(maoTwoPairs) must be(TwoPairs)
    }

    "reconhecer uma mao de three of a king" in {
      jogadaOf(maoThree) must be(ThreeOfAKind)
    }

    "reconhecer uma mao de straight lowAce" in {
      jogadaOf(maoStraightLowAce) must be(Straight)
    }

    "reconhecer uma mao de straight nao ordenada" in {
      jogadaOf(maoStraightNonOrdered) must be(Straight)
    }

    "reconhecer uma mao de straight flush" in {
      jogadaOf(maoStraightFlush) must be(StraightFlush)
    }

    "reconhecer uma mao de flush" in {
      jogadaOf(maoFlush) must be(Flush)
    }

    "reconhecer uma mao de full house" in {
      jogadaOf(maoFullHouse) must be(FullHouse)
    }

    "reconhecer uma mao de four" in {
      jogadaOf(maoFour) must be(FourOfAKind)
    }

    "identificar ordem das jogadas" in {
      jogadaOf(maoStraightLowAce) > jogadaOf(maoHighestCard) must beTrue
    }
  }

}
