package binarySearch.medium

object Leet153FindMinimuminRotatedSortedArray {
  def findMin(nums: Array[Int]): Int = {
    if (nums.head <= nums.last) nums.head
    else {
      if (nums.length == 1)
        nums.head
      else if (nums.length == 2)
        Math.min(nums.head, nums.last)
      else search(0, nums.length - 1, nums)
    }
  }

  private def search(left: Int, right: Int, nums: Array[Int]): Int = {
    if (left >= right) nums(left)
    else {
      val mid = (left + right) / 2
      if (mid != 0 && mid != nums.length - 1 && nums(mid - 1) > nums(mid) && nums(mid + 1) > nums(mid))
        nums(mid)
      else if (mid != 0 && mid != nums.length - 1 && nums(mid) > nums(mid - 1) &&
        (nums(left) < nums(mid) && nums(right) > nums(left)) || (nums(left) > nums(mid) && nums(left) > nums(right)))
        search(left, mid - 1, nums)
      else search(mid + 1, right, nums)
    }
  }
}
