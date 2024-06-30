package arrays.medium

object Leet75SortColors {
  def sortColors(nums: Array[Int]): Unit = {
    sort(0, nums.length - 1, 0, nums)
  }

  def sort(left: Int, right: Int, idx: Int, nums: Array[Int]): Unit = {
    if (idx <= right) {
      if (nums(idx) == 0) {
        swap(left, idx, nums)
        sort(left + 1, right, idx + 1, nums)
      } else if (nums(idx) == 1) {
        sort(left, right, idx + 1, nums)
      } else {
        swap(right, idx, nums)
        sort(left, right - 1, idx, nums)
      }
    }
  }

  def swap(idx1: Int, idx2: Int, nums: Array[Int]) = {
    val temp = nums(idx1)
    nums.update(idx1, nums(idx2))
    nums.update(idx2, temp)
  }

}
