package poker.model

case class Carta(valor: String) {
  
  require(Carta.isValido(valor))

}

object Carta {
  
  val pattern = "[A0-9TJQK][CDSH]".r

  def isValido(str: String) = pattern.unapplySeq(str).isDefined 

}
