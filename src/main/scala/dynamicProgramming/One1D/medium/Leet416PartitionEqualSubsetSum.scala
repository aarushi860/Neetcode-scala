package dynamicProgramming.One1D.medium

object Leet416PartitionEqualSubsetSum {
  def canPartition(nums: Array[Int]): Boolean = {
    if (nums.sum % 2 != 0) false
    else {
      val sum = nums.sum / 2
      findSum(0, nums, sum, Array.fill(nums.length + 1, sum + 1)(-1))
    }
  }

  private def findSum(idx: Int, nums: Array[Int], currentSum: Int, dp: Array[Array[Int]]): Boolean = {
    if (currentSum == 0) true
    else if (idx == nums.length || currentSum < 0) false
    else {
      if (dp(idx)(currentSum) != -1) dp(idx)(currentSum) == 0
      else {
        val result = findSum(idx + 1, nums, currentSum - nums(idx), dp) || findSum(idx + 1, nums, currentSum, dp)
        if (result) dp(idx)(currentSum) = 0
        else dp(idx)(currentSum) = 1
        result
      }
    }
  }


}
