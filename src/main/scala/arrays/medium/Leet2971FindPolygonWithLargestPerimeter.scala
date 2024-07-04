package arrays.medium

object Leet2971FindPolygonWithLargestPerimeter {
  def largestPerimeter(nums: Array[Int]): Long = {
    getMaxPerimeter(nums.sorted, 2, 0, -1)
  }

  private def getMaxPerimeter(nums: Array[Int],
                              idx: Int,
                              prevSum: Long,
                              max: Long
                             ): Long = {
    if (idx == nums.length)
      max
    else {
      val updatedMax = if (prevSum > nums(idx)) Math.max(max, prevSum + nums(idx)) else max
      getMaxPerimeter(nums, idx + 1, prevSum + nums(idx), updatedMax)
    }
  }
}
