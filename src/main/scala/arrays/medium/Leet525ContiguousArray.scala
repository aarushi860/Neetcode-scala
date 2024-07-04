package arrays.medium

object Leet525ContiguousArray {
  def findMaxLength(nums: Array[Int]): Int = {
    getPairs(Map(0 -> -1), 0, 0, nums, 0)
  }


  def getPairs(countMap: Map[Int, Int], count: Int, idx: Int, nums: Array[Int], max: Int): Int = {
    if (idx == nums.length)
      max
    else {
      val currValue = if (nums(idx) == 0) -1 else 1
      val updatedCount = count + currValue
      if (countMap.contains(updatedCount)) {
        val updatedMax = Math.max(max, idx - countMap(updatedCount))
        getPairs(countMap, updatedCount, idx + 1, nums, updatedMax)
      } else getPairs(countMap.updated(updatedCount, idx), updatedCount, idx + 1, nums, max)
    }
  }
}
