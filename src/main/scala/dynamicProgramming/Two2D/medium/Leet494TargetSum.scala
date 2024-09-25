package dynamicProgramming.Two2D.medium

object Leet494TargetSum {
  def findTargetSumWays(nums: Array[Int], target: Int): Int = {
    val sum = nums.sum * 2
    val dp = Array.fill(nums.length, sum + 1)(-1)
    findTargetWithDp(nums, target, dp, nums.sum, 0)
  }

  private def findTargetWithDp(nums: Array[Int], target: Int, dp: Array[Array[Int]], sum: Int,
                               idx: Int): Int = {
    if (idx == nums.length) {
      if (sum == target) 1 else 0
    }
    else if (dp(idx)(target) != -1) dp(idx)(target)
    else {
      val result = findTargetWithDp(nums, target, dp, sum + nums(idx), idx + 1) + findTargetWithDp(nums, target, dp, sum - nums(idx), idx + 1)
      dp(idx)(sum) = result
      result
    }
  }
}
