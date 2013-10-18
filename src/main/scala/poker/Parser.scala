package poker

import poker.model._
import scala.util.parsing.combinator.RegexParsers

object Parser extends RegexParsers {
  
  def carta = Carta.pattern ^^ { Carta(_)}

  def cartas = repN(5, carta) ^? ({ case cartas if (cartas == cartas.removeDuplicates) => cartas.toSet }, { "carta duplicada " + _ })

  def mao = cartas

  def monte = cartas

  def linha = mao ~ monte

  def linhas = rep(linha)
}
