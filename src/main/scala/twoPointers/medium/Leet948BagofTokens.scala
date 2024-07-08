package twoPointers.medium

object Leet948BagofTokens {
  def bagOfTokensScore(tokens: Array[Int], power: Int): Int = {
    tokens.sortInPlace
    getScore(0, 0, tokens.length - 1, tokens, power)
  }

  private def getScore(score: Int, low: Int, high: Int, tokens: Array[Int], power: Int): Int = {
    if (low > high)
      score
    else {
      if (tokens(low) <= power)
        getScore(score + 1, low + 1, high, tokens, power - tokens(low))
      else if (low < high && score > 0)
        getScore(score - 1, low, high - 1, tokens, power + tokens(high))
      else score
    }
  }
}
