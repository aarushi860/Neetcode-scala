package slidingWindow.medium

object Leet992SubarrayswithKDifferentIntegers {
  def subarraysWithKDistinct(nums: Array[Int], k: Int): Int = {
    nums.zipWithIndex.foldLeft(Map.empty[Int, Int], 0, 0) {
      case ((fMap, left, count), (num, idx)) =>
        val fq = fMap.getOrElse(num, 0)
        val updatedMap = fMap.updated(num, fq + 1)
        update(left, updatedMap, nums, k, count)
    }._3
  }
//1,2,1,2,3
// 1,1,2,2,3
  private def update(left: Int, fMap: Map[Int, Int], nums: Array[Int], k: Int, count: Int): (Map[Int, Int], Int, Int) = {
    if (fMap.keys.size > k) {
      val leftCount = fMap(nums(left)) - 1
      val updatedMap = if (leftCount == 0) fMap.removed(nums(left)) else fMap.updated(nums(left), leftCount)
      update(left + 1, updatedMap, nums, k, count)
    } else if (fMap.keys.size == k) {
      (fMap, left, count + 1)
    } else (fMap, left, count)
  }
}
