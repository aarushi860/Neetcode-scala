package binarySearch.medium

object Leet34FindFirstandLastPositionofElementinSortedArray {
  def searchRange(nums: Array[Int], target: Int): Array[Int] = {
    val result = find(0, nums.length - 1, nums, target)
    Array(result._1, result._2)
  }

  private def find(left: Int, right: Int, nums: Array[Int], target: Int): (Int, Int) = {
    if (left > right) (-1, -1)
    else {
      val mid = (left + right) / 2
      if (nums(mid) == target && (mid == 0 || nums(mid - 1) != target)) {
        val rightIdx = nums.zipWithIndex.takeRight(nums.length - mid).takeWhile(_._1 == target).last._2
        (mid, rightIdx)
      } else if (nums(mid) < target) {
        find(mid + 1, right, nums, target)
      } else find(left, mid - 1, nums, target)
    }
  }


}
