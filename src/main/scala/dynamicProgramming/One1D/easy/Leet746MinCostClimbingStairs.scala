package dynamicProgramming.One1D.easy

object Leet746MinCostClimbingStairs {
  def minCostClimbingStairs(cost: Array[Int]): Int = {
    val dp = Array.fill(cost.length + 1)(0)
    (2 to cost.length).foreach { i =>
      dp(i) = Math.min(cost(i - 1) + dp(i - 1), cost(i - 2) + dp(i - 2))
    }
    dp(cost.length)
  }

}
