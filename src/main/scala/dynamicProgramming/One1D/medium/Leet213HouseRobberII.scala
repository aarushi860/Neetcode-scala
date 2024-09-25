package dynamicProgramming.One1D.medium

object Leet213HouseRobberII {
  def rob(nums: Array[Int]): Int = {
    nums.init
    if (nums.length == 0)
      nums(0)
    else {
      val dp1 = Array.fill(nums.length)(0)
      val dp2 = Array.fill(nums.length)(0)
      dp1(0) = nums(0)
      dp1(1) = Math.max(nums(0), nums(1))
      (2 until nums.length - 1).foreach { i =>
        dp1(i) = Math.max(dp1(i - 1), dp1(i - 2) + nums(i))
      }
      dp2(0) = 0
      dp2(1) = nums(1)
      (2 until nums.length).foreach { i =>
        dp2(i) = Math.max(dp2(i - 1), dp2(i - 2) + nums(i))
      }
      Math.max(dp1(nums.length - 2), dp2(nums.length - 1))
    }
  }
}
