package dynamicProgramming.One1D.medium

import scala.collection.mutable

object Leet300LongestIncreasingSubsequence {
  def lengthOfLIS(nums: Array[Int]): Int = {
    val result = mutable.ListBuffer(nums(0))
    (1 until nums.length).foreach { idx =>
      if (nums(idx) > result.last)
        result.addOne(nums(idx))
      else {
        val j: Int = binarySearch(0,result.size-1, result, nums(idx))
        result(j) = nums(idx)
      }
    }
    result.length
  }

  private def binarySearch(left: Int, right: Int, list: mutable.ListBuffer[Int], num: Int): Int = {
    if (left >= right) right
    else {
      val mid = (left + right) / 2
      if (list(mid) >= num)
        binarySearch(left, mid, list, num)
      else binarySearch(mid + 1, right, list, num)
    }
  }


}
