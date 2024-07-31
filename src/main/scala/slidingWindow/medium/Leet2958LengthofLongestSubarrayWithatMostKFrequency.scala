package slidingWindow.medium

object Leet2958LengthofLongestSubarrayWithatMostKFrequency {
  def maxSubarrayLength(nums: Array[Int], k: Int): Int = {
    nums.zipWithIndex.foldLeft(0, 0, Map.empty[Int, Int]) {
      case ((max, left, fMap), (num, idx)) =>
        val count = fMap.getOrElse(num, 0)
        val (updatedLeft, updatedMap) = if (count == k) moveWindow(fMap, left, idx, nums) else (left, fMap.updated(num,count+1))
        (Math.max(idx - updatedLeft + 1, max), updatedLeft, updatedMap)
    }._1
  }

  private def moveWindow(fMap: Map[Int, Int], left: Int, idx: Int, nums: Array[Int]): (Int, Map[Int, Int]) = {
    if (nums(left) == nums(idx))
      (left + 1, fMap)
    else {
      val leftCount = fMap(nums(left))
      moveWindow(fMap.updated(nums(left), leftCount - 1), left + 1, idx, nums)
    }
  }
}
