package poker

import poker.model._
import scala.util.parsing.combinator.RegexParsers

object Parser extends RegexParsers {
  
  def carta: Parser[Carta] = Carta.pattern ^^ { Carta(_)}

  def cartas = repN(5, carta) ^? ({ case cartas if (cartas == cartas.removeDuplicates) => cartas }, { "carta duplicada " + _ })

  def mao: Parser[Mao] = cartas ^^ { Mao(_) }

  def monte: Parser[Monte] = cartas ^^ { Monte(_) }

  def linha: Parser[PsychoMao] = mao ~ monte ^? 
  ({ case mao ~ monte if (mao.cartas.intersect(monte.cartas).isEmpty) => PsychoMao(mao, monte) }, 
   { "carta duplicada entre a mao e o monte" + _ })

  def linhas: Parser[List[PsychoMao]] = rep(linha)

  def apply(input: java.io.Reader): List[PsychoMao] = parseAll(linhas, input) match {
    case Success(result, _) => result
    case failure : NoSuccess => scala.sys.error(failure.msg)
  }

}
