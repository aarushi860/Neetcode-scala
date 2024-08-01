package slidingWindow.medium

import jdk.internal.net.http.frame.GoAwayFrame

object Leet930BinarySubarraysWithSum {
  def numSubarraysWithSum(nums: Array[Int], goal: Int): Int = {
    nums.zipWithIndex.foldLeft(0, 0, 0) {
      case ((totalCount, left, currSum), (num, idx)) =>

        val (prefixSum, updatedLeft, updatedCurrSum) = getUpdated(currSum + num, left, 0, idx, goal, nums)
        val updatedCount = if (updatedCurrSum == goal) totalCount + prefixSum + 1 else totalCount
        (updatedCount, updatedLeft, updatedCurrSum)
    }._1
  }

  private def getUpdated(currSum: Int, left: Int, prefixZero: Int, idx: Int, goal: Int, nums: Array[Int]): (Int, Int, Int) = {
    if (left <= idx && (currSum > goal || nums(left) == 0)) {
      if (nums(left) == 0)
        getUpdated(currSum, left + 1, prefixZero + 1, idx, goal, nums)
      else getUpdated(currSum - 1, left + 1, prefixZero, idx, goal, nums)
    } else (prefixZero, left, currSum)
  }


}
