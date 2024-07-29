package slidingWindow.medium

object Leet1838FrequencyofMostFreqElement {

  def maxFrequency(nums: Array[Int], k: Int): Int = {
    nums.sortInPlace.zipWithIndex.foldLeft(0, 0L, 0) {
      case ((left, curr, max), (num, idx)) =>

        val (updatedLeft, updatedCurr) = getOptimisedWindow(nums, k, left, idx, curr + nums(idx))
        val updatedMax = Math.max(max, idx - updatedLeft + 1)
        (updatedLeft, updatedCurr, updatedMax)
    }._3
  }

  private def getOptimisedWindow(nums: Array[Int], k: Int, left: Int, idx: Int, curr: Long): (Int, Long) = {
    if (((idx - left + 1) * nums(idx) - curr) > k)
      getOptimisedWindow(nums, k, left + 1, idx, curr - nums(left))
    else (left, curr)
  }

}
