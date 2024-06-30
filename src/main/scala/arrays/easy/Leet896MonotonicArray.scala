package arrays.easy

object Leet896MonotonicArray {
  def isMonotonic(nums: Array[Int]): Boolean = {
    val isIncreasing = checkCondition(nums, 0, (a, b) => a <= b)
    if (isIncreasing) true
    else checkCondition(nums, 0, (a, b) => a >= b)
  }

  private def checkCondition(nums: Array[Int], idx: Int, f: (Int, Int) => Boolean): Boolean = {
    if (idx < nums.length - 1) {
      if (f(nums(idx), nums(idx + 1)))
        checkCondition(nums, idx + 1, f)
      else false
    } else true
  }
}
