package slidingWindow.medium

object Leet930BinarySubarraysWithSum {
  def numSubarraysWithSum(nums: Array[Int], goal: Int): Int = {
    nums.zipWithIndex.foldLeft(0, 0, 0) {
      case ((count, curr, left), (num, idx)) =>
        getUpdated(left, curr + num, nums, idx, goal, count)
    }._1
  }

  private def getUpdated(left: Int, curr: Int, nums: Array[Int], right: Int, goal: Int, count: Int): (Int, Int, Int) = {
    if (curr >= goal && left <= right)
      getUpdated(left + 1, curr - nums(left), nums, right, goal, if (curr == goal) count + 1 else count)
    else (count, curr, left)
  }
}
