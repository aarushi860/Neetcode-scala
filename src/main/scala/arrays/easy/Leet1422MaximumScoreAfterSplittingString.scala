package arrays.easy

object Leet1422MaximumScoreAfterSplittingString {
  def maxScore(s: String): Int = {
    val total = s.count(_=='1')
    getMax(0, 1, s, total, (0, 0))
  }

  def getMax(max: Int, leftPointer: Int, s: String, totalCountOne:  Int, currCount: (Int, Int)): Int = {
    if (leftPointer < s.length) {
      val ch = s.charAt(leftPointer - 1)
      val currCountUpdated = updateCurrCount(currCount, ch)
      val curr = currCountUpdated._1 + totalCountOne - currCountUpdated._2
      getMax(math.max(max, curr), leftPointer + 1, s, totalCountOne, currCountUpdated)
    } else max
  }

  private def updateCurrCount(currCount: (Int, Int), ch: Char) = {
    if (ch == '0')
      (currCount._1 + 1, currCount._2)
    else (currCount._1, currCount._2 + 1)
  }

}
