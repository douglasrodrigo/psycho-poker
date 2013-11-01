package poker.model

case class Carta(valor: String) {
  
  require(Carta.isValido(valor))

  lazy val numero = valor.head

  lazy val naipe = valor.last

  lazy val valorNumero = numero match {
    case 'T' => 10
    case 'J' => 11
    case 'Q' => 12
    case 'K' => 13
    case 'A' => 14
    case d => d.asDigit
  }

  override def toString = valor
}

object Carta {
  
  val pattern = "[A2-9TJQK][CDSH]".r

  def isValido(str: String) = pattern.unapplySeq(str).isDefined 
}
