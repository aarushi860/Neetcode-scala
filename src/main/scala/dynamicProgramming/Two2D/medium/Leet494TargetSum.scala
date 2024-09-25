package dynamicProgramming.Two2D.medium

object Leet494TargetSum {
  var total=0
  def findTargetSumWays(nums: Array[Int], target: Int): Int = {
    total=nums.sum
    val sum = nums.sum * 2
    val dp = Array.fill(nums.length, sum + 1)(-1)
    findTargetWithDp(nums, target, dp, nums.sum, 0)
  }

  private def findTargetWithDp(nums: Array[Int], target: Int, dp: Array[Array[Int]], sum: Int,
                               idx: Int): Int = {
    if (idx == nums.length) {
      if (sum == target) 1 else 0
    }
    else if (dp(idx)(total+sum) != -1) dp(idx)(total+sum)
    else {
      val result = findTargetWithDp(nums, target, dp, sum + nums(idx), idx + 1) + findTargetWithDp(nums, target, dp, sum - nums(idx), idx + 1)
      dp(idx)(total+sum) = result
      result
    }
  }
}
