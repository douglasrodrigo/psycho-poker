package poker.model

object Jogada extends Enumeration {
  type Jogada = Value

  val HighestCard = Value("highest-card (maior carta)")
  val OnePair = Value("one pair (1 par)")
  val TwoPairs = Value("two-pairs (2 pares)")
  val ThreeOfAKind = Value("three-of-a-kind (trinca)")
  val Straight = Value("straight (sequência numérica)")
  val Flush = Value("flush (sequência de naipe)")
  val FullHouse = Value("full-house (trinca + par)")
  val FourOfAKind = Value("four-of-a-kind (quadra)")
  val StraightFlush = Value("straight-flush (sequência numérica e de naipe)")

  private def isSequence(cartas: List[Carta]) = {
      val cartasOrdenadas = cartas.map(_.valorNumero).sorted
      cartas.map(_.numero).toSet == Set('A', '2', '3', '4', '5') || 
        (cartasOrdenadas.head to cartasOrdenadas.last).toList.sameElements(cartasOrdenadas)
  }

  def jogadaOf(cartas: List[Carta]) = (cartas, cartas.groupBy(_.numero).mapValues(_.size)) match {
    case (cartas, _) if isSequence(cartas) => if (cartas.groupBy(_.naipe).size == 1)  StraightFlush else Straight
    case (_, grupos) if grupos.find(_._2 == 4).isDefined => FourOfAKind
    case (_, grupos) if grupos.find(_._2 == 3).isDefined && grupos.find(_._2 == 2).isDefined => FullHouse
    case (cartas, _) if cartas.groupBy(_.naipe).size == 1 => Flush
    case (_, grupos) if grupos.size == 3 && grupos.find(_._2 == 3).isDefined => ThreeOfAKind
    case (_, grupos) if grupos.filter(_._2 == 2).size == 2 => TwoPairs
    case (_, grupos) if grupos.size == 4 => OnePair
    case _ => HighestCard
  }
}
