package arrays.medium

object Leet2348NumberofZeroFilledSubarrays {
  def zeroFilledSubarray(nums: Array[Int]): Long = {
    calculate(0, 0, nums, 0)
  }

  def calculate(count: Long, current: Int, nums: Array[Int], idx: Int): Long = {
    if (idx == nums.length)
      count
    else {
      val updatedCurrent = if (nums(idx) != 0) 0
      else current + 1
      calculate(count + updatedCurrent, updatedCurrent, nums, idx + 1)
    }
  }
}
