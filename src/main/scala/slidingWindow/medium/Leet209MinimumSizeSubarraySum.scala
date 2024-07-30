package slidingWindow.medium


//2,3,1,2,4,3
object Leet209MinimumSizeSubarraySum {
  def minSubArrayLen(target: Int, nums: Array[Int]): Int = {
    if (nums.sum < target)
      0
    else {
      nums.zipWithIndex.foldLeft(Integer.MAX_VALUE, 0, 0) {
        case ((min, currSum, left), (num, idx)) =>
          val updatedSum = currSum + num
          if (updatedSum >= target) {
            val (sum, updatedLeft, updatedMin) = getMin(updatedSum, left, target, nums, min, idx)
            (updatedMin, sum, updatedLeft)
          } else (min, updatedSum, left)
      }._1
    }
  }

  private def getMin(sum: Int, left: Int, target: Int, nums: Array[Int], min: Int, idx: Int): (Int, Int, Int) = {
    if (left == nums.length || sum < target)
      (sum, left, min)
    else
      getMin(sum - nums(left), left + 1, target, nums, Math.min(idx - left + 1, min), idx)
  }
}
