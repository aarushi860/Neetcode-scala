package dynamicProgramming.One1D.medium

object Leet198HouseRobber {
  def rob(nums: Array[Int]): Int = {
    if (nums.length == 1) nums(0)
    else {
      val dp = Array.fill(nums.length)(0)
      dp(0) = nums(0)
      dp(1) = Math.max(nums(0), nums(1))
      (2 until nums.length).foreach { i =>
        dp(i) = Math.max(dp(i - 1), dp(i - 2) + nums(i))
      }
      dp(nums.length - 1)
    }
  }
}
