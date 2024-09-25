package dynamicProgramming.Two2D.medium

object Leet518CoinChangeII {
  def change(amount: Int, coins: Array[Int]): Int = {
    val dp = Array.fill(amount + 1)(0)
    dp(0) = 1
    coins.foreach { coin =>
      (coin to amount).foreach { i =>
        dp(i) += dp(i - coin)
      }
    }
    dp(amount)
  }

}
