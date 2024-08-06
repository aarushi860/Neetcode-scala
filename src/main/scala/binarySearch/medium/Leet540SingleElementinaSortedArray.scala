package binarySearch.medium

object Leet540SingleElementinaSortedArray {
  def singleNonDuplicate(nums: Array[Int]): Int = {
    find(0, nums.length - 1, nums)
  }

  private def find(left: Int, right: Int, nums: Array[Int]): Int = {
    if (left >= right) nums(left)
    else {
      val mid = (left + right) / 2
      val halvesEven = (right - mid) % 2 == 0
      mid match {
        case i if nums(i) == nums(i + 1) =>
          if (halvesEven) find(mid + 2, right, nums)
          else find(left, mid - 1, nums)
        case i if (nums(i) == nums(i - 1)) =>
          if (halvesEven) find(left, mid - 2, nums)
          else find(mid + 1, right, nums)
        case _ => nums(mid)
      }
    }
  }
}
