package slidingWindow.easy

object Leet219ContainsDuplicateII {
  def containsNearbyDuplicate(nums: Array[Int], k: Int): Boolean = {
    exists(Map.empty, k, 0, nums)
  }


  private def exists(map: Map[Int, Int], k: Int, idx: Int, nums: Array[Int]): Boolean = {
    if (idx == nums.length)
      false
    else {
      val num = nums(idx)
      if (map.contains(num) && idx - map(num) <= k) {
        true
      } else exists(map.updated(num, idx), k, idx + 1, nums)
    }
  }
}
