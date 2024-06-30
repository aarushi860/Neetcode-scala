//package arrays.medium
//
//object Leet560SubarraySumEqualsK {
//
//  def subarraySum(nums: Array[Int], k: Int): Int = {
//    getCount(0, nums, k, Map((0,1)), 0, 0)
//  }
//
//  private def getCount(idx: Int, nums: Array[Int], k: Int, map: Map[Int, Int], sum: Int, count: Int): Int = {
//    if (idx < nums.length) {
//      val updated = sum + nums(idx)
//      val availableCount = map.getOrElse(k - nums, 0)
//      getCount(idx + 1, nums, k, map.updated(updated, map.getOrElse(updated, 0) + 1), updated, count + availableCount)
//    } else count
//  }
//
//
//}
