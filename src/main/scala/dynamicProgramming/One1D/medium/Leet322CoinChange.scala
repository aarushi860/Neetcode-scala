package dynamicProgramming.One1D.medium

import scala.collection.mutable

object Leet322CoinChange {
  def coinChange(coins: Array[Int], amount: Int): Int = {
    getMin(coins, amount, mutable.Map.empty)
  }

  private def getMin(coins: Array[Int], amount: Int, memo: mutable.Map[Int, Int]): Int = {
    if (amount == 0) 0
    else if (memo.contains(amount)) memo(amount)
    else {
      val minCoinsOption = coins.map { coin => getMin(coins, amount - coin, memo)}.filterNot(_<0).minOption
      memo.put(amount, minCoinsOption.map(_ + 1).getOrElse(-1))
      memo(amount)
    }
  }
}
