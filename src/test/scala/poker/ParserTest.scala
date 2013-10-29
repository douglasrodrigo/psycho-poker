package poker

import poker.model._
import org.specs2.mutable._
import org.specs2.matcher.ParserMatchers
import poker.Parser.{carta, cartas, linha}

class ParserTest extends Specification with ParserMatchers {
  val parsers = poker.Parser

  "Parser carta" should {
    "Sucesso ao reconhecer uma carta" in {
      carta("4C") must beASuccess
    }

    "falhar em carta com formato invalido" in {
      carta must failOn("93")
    }
  }

  "Parser cartas" should {
    "Sucesso ao reconhecer 5 cartas" in {
      cartas("4C 5C 6C 7C 8D") must beASuccess
    }

    "falhar em reconhecer menos de 5 cartas" in {
      cartas must failOn("AD 2D")
    }

    "falhar em reconhecer mais de 5 cartas" in {
      cartas must failOn("AD 2D 3D 4D 5D 6D")
    }

    "falhar com cartas repetidas" in {
      cartas must failOn("AD 2D 3D 4D 4D")
    }

  }

  "Parser linha" should {
    "Sucesso ao reconhecer uma mao e o monte" in {
      linha("4C 5C 6C 7C 8D 2D 3D 4D 5D 6D") must beASuccess
    }

    "falhar em reconhecer menos de 10 cartas" in {
      linha must failOn("AD 2D")
    }

    "falhar em reconhecer mais de 10 cartas" in {
      linha must failOn("4C 5C 6C 7C 8D 2D 3D 4D 5D 6D 7D")
    }

    "falhar com cartas repetidas entre a mao e o monte" in {
      linha must failOn("4C 5C 6C 7C 8D 2D 3D 4C 5D 6D")
    }

  }

}
