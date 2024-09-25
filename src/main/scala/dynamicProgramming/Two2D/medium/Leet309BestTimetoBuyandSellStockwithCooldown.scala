package dynamicProgramming.Two2D.medium

object Leet309BestTimetoBuyandSellStockwithCooldown {
  def maxProfit(prices: Array[Int]): Int = {
    maxProfitDP(0, prices, Array.fill(prices.length, 3)(-1),0)
  }

  private def maxProfitDP(idx: Int, prices: Array[Int], dp: Array[Array[Int]], state: Int): Int = {
    if (idx == prices.length) 0
    else if (dp(idx)(state) != -1) dp(idx)(state)
    else {
      val doNothing = maxProfitDP(idx + 1, prices, dp, state)
      val result = if (state == 0) Math.max(doNothing, maxProfitDP(idx + 1, prices, dp, 1) - prices(idx))
      else if (state == 1)  maxProfitDP(idx + 1, prices, dp, 0)
      else Math.max(doNothing, maxProfitDP(idx + 1, prices, dp, 1)+ prices(idx))
      dp(idx)(state) = result
      result
    }
  }
}
