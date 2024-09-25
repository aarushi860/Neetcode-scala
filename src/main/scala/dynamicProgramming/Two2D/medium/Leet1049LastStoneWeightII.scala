package dynamicProgramming.Two2D.medium

object Leet1049LastStoneWeightII {
  def lastStoneWeightII(stones: Array[Int]): Int = {
    lastStoneWeightIIDP(stones, Array.fill(stones.length, stones.sum + 1)(-1), 0, 0, 0)
  }

  private def lastStoneWeightIIDP(stones: Array[Int], dp: Array[Array[Int]],
                                  left: Int, right: Int, idx: Int): Int = {
    if (idx == stones.length) Math.abs(left - right)
    else if (dp(idx)(left) != -1) dp(idx)(left)
    else {
      val resul = Math.min(lastStoneWeightIIDP(stones, dp, left + stones(idx), right, idx + 1),
        lastStoneWeightIIDP(stones, dp, left, right + stones(idx), idx + 1))
      dp(idx)(left) = resul
      resul
    }
  }
}
