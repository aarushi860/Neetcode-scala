package slidingWindow.medium


//2,3,1,2,4,3
object Leet209MinimumSizeSubarraySum {

  //[2,3,1,2,4,3]
  def minSubArrayLen(target: Int, nums: Array[Int]): Int = {

    val min = nums.zipWithIndex.foldLeft(0, 0, Integer.MAX_VALUE) {
      case ((left, currSum, min), (num, idx)) =>
        getMin(left, idx, min, currSum + num, target, nums)
    }._3
    if (min == Integer.MAX_VALUE) 0 else min
  }

  def getMin(left: Int, idx: Int, min: Int, currSum: Int, target: Int, nums: Array[Int]): (Int, Int, Int) = {
    if (currSum >= target && left <= idx) {
      getMin(left + 1, idx, Math.min(min, idx - left + 1), currSum - nums(left), target, nums)
    } else (left, currSum, min)
  }


}
