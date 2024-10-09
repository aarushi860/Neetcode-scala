package binarySearch.hard

object Leet410SplitArrayLargestSum {
  def splitArray(nums: Array[Int], k: Int): Int = {
    val right = nums.sum
    val left = nums.max
    findOPtimal(left, right, nums, k)
  }

  private def findOPtimal(left: Int, right: Int, nums: Array[Int], k: Int): Int = {
    if (left <= right) {
      val mid = left + (right - left) / 2
      val splits = countSplits(mid, nums)
      if (splits > k) findOPtimal(mid + 1, right, nums, k)
      else findOPtimal(left, mid, nums, k)
    } else right
  }

  private def countSplits(sum: Int, nums: Array[Int]) = {
    nums.foldLeft(0, 0) {
      case ((splits, currentSum), num) =>
        if (currentSum + num > sum)
          (splits + 1, num)
        else (splits, currentSum + num)
    }._1 + 1
  }
}
