package linkedList.medium

object Leet287FindtheDuplicateNumber {
  def findDuplicate(nums: Array[Int]): Int = {
    val result = findOrUpdate(nums, 0)
    nums.indices.foreach { x =>
      if (nums(x) < 0) nums.update(x, -1 * nums(x))
    }
    result
  }

  private def findOrUpdate(nums: Array[Int], idx: Int): Int = {
    val num = Math.abs(nums(idx))
    val numAtIdx = nums(num - 1)
    if (numAtIdx < 0) num
    else {
      nums.update(num - 1, -1 * numAtIdx)
      findOrUpdate(nums, idx + 1)
    }
  }
}
