package backtracking.medium

//not working
object Leet473MatchsticksToSquare {
  def makesquare(matchsticks: Array[Int]): Boolean = {
    val sum = matchsticks.sum
    if (sum % 4 != 0) false
    else possible(sum / 4, 4, Set.empty, matchsticks, 0, 0)
  }

  private def possible(sq: Int, sidesLeft: Int, used: Set[Int], matchsticks: Array[Int], formedSq: Int, idx: Int): Boolean = {
    if (sidesLeft == 0) true
    else if (used.size == matchsticks.length) false
    else {
      matchsticks.indices.filter(_ >= idx).filterNot(used).exists { i =>
        val size = matchsticks(idx)
        val newFormed = formedSq + size
        if (newFormed < sq) possible(sq, sidesLeft, used.+(i), matchsticks, newFormed, i + 1)
        else if (newFormed == sq) possible(sq, sidesLeft - 1, used.+(i), matchsticks,0, i + 1)
        else false
      }
    }
  }
}
