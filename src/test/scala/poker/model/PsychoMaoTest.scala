package poker.model

import poker.model._
import org.specs2.mutable._
import poker.model.Jogada._

class PsychoMaoTest extends Specification {

  val maoFour = Mao(List(Carta("AC"), Carta("AS"), Carta("AD"), Carta("AH"), Carta("TC")))

  val montePair = Monte(List(Carta("QS"), Carta("QS"), Carta("KC"), Carta("5S"), Carta("7C")))

  val maoHighestCard = Mao(List(Carta("AC"), Carta("3S"), Carta("6D"), Carta("JH"), Carta("TC")))

  val maoPartOfSequence = Mao(List(Carta("AC"), Carta("2D"), Carta("9C"), Carta("3S"), Carta("KD")))

  val montePartOfSequence = Monte(List(Carta("5S"), Carta("4D"), Carta("KS"), Carta("AS"), Carta("4C")))

  "PsychoMao melhorJogada" should {

    "reconhecer as cartas da mao como Four e melhor jogada" in {
      PsychoMao(maoFour, montePair).melhorJogada must be(FourOfAKind)
    }

    "reconhecer as cartas do monte como Pair e melhor jogada" in {
      PsychoMao(maoHighestCard, montePair).melhorJogada must be(OnePair)
    }

    "reconhecer as cartas da mao e do monte monte como Straight e melhor jogada" in {
      PsychoMao(maoPartOfSequence, montePartOfSequence).melhorJogada must be(Straight)
    }
  }
}
