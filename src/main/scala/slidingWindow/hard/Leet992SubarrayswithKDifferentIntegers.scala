package slidingWindow.hard

//not working
object Leet992SubarrayswithKDifferentIntegers {
  def subarraysWithKDistinct(nums: Array[Int], k: Int): Int = {
    nums.zipWithIndex.foldLeft(0, 0, Map.empty[Int, Int]) {
      case ((result, start, map), (num, idx)) =>
        val updatedMap = map.updated(num, map.getOrElse(num, 0) + 1)
        if (updatedMap.keys.size == k) {
          val x = shrinkAndCheck(start, idx, updatedMap, k, nums, result)
          (x._1, x._2, updatedMap)
        } else (result, start, updatedMap)
    }._1
  }

  private def shrinkAndCheck(left: Int, right: Int, map: Map[Int, Int], k: Int, nums: Array[Int], result: Int)
  : (Int, Int, Map[Int, Int]) = {
    if (left <= right && map.keySet.size == k) {
      val leftCount = map(nums(left))
      val updatedMap = map.updated(nums(left), leftCount - 1)
      if (leftCount == 1) {
        (result + 1, left + 1, updatedMap.removed(nums(left)))
      } else shrinkAndCheck(left + 1, right, updatedMap, k, nums, result + 1)
    } else (result, left, map)
  }
}
