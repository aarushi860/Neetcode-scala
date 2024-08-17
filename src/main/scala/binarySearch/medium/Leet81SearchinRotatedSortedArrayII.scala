package binarySearch.medium

object Leet81SearchinRotatedSortedArrayII {
  def search(nums: Array[Int], target: Int): Boolean = {
    find(0, nums.length - 1, nums, target)
  }

  private def find(left: Int, right: Int, nums: Array[Int], target: Int): Boolean = {
    if (left > right) false
    else {
      val mid = (left + right) / 2
      if (nums(mid) == target)
        true
      else if(nums(mid)==nums(left) && nums(mid)==nums(right))
        find(left+1,right-1, nums, target)
      else if (nums(mid) >= nums(left)) {
        if (target >= nums(left) && target < nums(mid))
          find(left, mid - 1, nums, target)
        else find(mid + 1, right, nums, target)
      } else {
        if (target <= nums(right) && target > nums(mid))
          find(mid + 1, right, nums, target)
        else find(left, mid - 1, nums, target)
      }
    }
  }
}
