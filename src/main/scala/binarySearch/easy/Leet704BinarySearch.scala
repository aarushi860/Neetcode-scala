package binarySearch.easy

object Leet704BinarySearch {
  def search(nums: Array[Int], target: Int): Int = {
    find(0, nums.length - 1, nums, target)
  }

  private def find(left: Int, right: Int, nums: Array[Int], target: Int): Int = {
    if (left > right) -1
    else {
      val mid = (left + right) / 2
      mid match {
        case i if nums(i) == target => i
        case i if nums(i) > target => find(left, mid - 1, nums, target)
        case _ => find(mid + 1, right, nums, target)
      }
    }
  }
}
