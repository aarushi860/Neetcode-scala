package arrays.medium

object Leet523ContinuousSubarraySum {

  def checkSubarraySum(nums: Array[Int], k: Int): Boolean = {

    checkExists(Map(0 -> -1), 0, 0, nums, k)
  }

  private def checkExists(map: Map[Int, Int], prefixMode: Int, idx: Int, nums: Array[Int], k: Int): Boolean = {
    if (idx == nums.length)
      false
    else {
      val updatedPrefixMode = (prefixMode + nums(idx)) % k
      if (map.contains(updatedPrefixMode)) {
        if (idx - map(updatedPrefixMode) > 1) true
        else checkExists(map, updatedPrefixMode, idx + 1, nums, k)
      } else checkExists(map.updated(updatedPrefixMode, idx), updatedPrefixMode, idx + 1, nums, k)
    }
  }
}
