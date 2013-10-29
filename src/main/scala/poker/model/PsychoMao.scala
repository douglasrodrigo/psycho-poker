package poker.model

import poker.model.Jogada._

case class Mao(cartas: List[Carta]) {
  require(cartas.size == 5,"exatamente 5 cartas")

  override def toString = cartas.mkString(" ")
}

case class Monte(cartas: List[Carta]) {
  require(cartas.size == 5,"exatamente 5 cartas")

  override def toString = cartas.mkString(" ")
}

case class PsychoMao(mao: Mao, monte: Monte) {

  def melhorJogada: Jogada = {
   (0 to monte.cartas.size).map(monte.cartas.take(_)).foldLeft(List[Jogada]()) {(jogadas, cartasMonte) =>
     mao.cartas.combinations(mao.cartas.size - cartasMonte.size).map(comb => jogadaOf(cartasMonte ++ comb)).toList ++ jogadas
   } max
  }

  override def toString = s"Mao: $mao Monte: $monte Melhor Jogo: $melhorJogada"
}
