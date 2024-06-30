package arrays.medium

object Leet128LongestConsecutiveSequence {
  def longestConsecutive(nums: Array[Int]): Int = {
    if (nums.isEmpty) 0
    else {
      val set = nums.toSet
      nums.foldLeft(1) { (longest, num) =>
        if (set.contains(num - 1)) longest
        else math.max(longest, countStreak(1, set, num))
      }
    }
  }

  private def countStreak(streak: Int, set: Set[Int], num: Int): Int = {
    if (set.contains(num + 1))
      countStreak(streak + 1, set, num + 1)
    else streak
  }


}
