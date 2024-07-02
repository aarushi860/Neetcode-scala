package arrays.medium

object Leet665NonDecreasingArray {
  def checkPossibility(nums: Array[Int]): Boolean = {
    verify(1, nums, 0)
  }

  private def verify(idx: Int, nums: Array[Int], count: Int): Boolean = {
    if (idx == nums.length)
      true
    else {
      if (nums(idx) < nums(idx-1)) {
        if (count == 1)
          false
        else {
          if (idx < 2 || nums(idx - 2) <= nums(idx))
            nums.update(idx - 1, nums(idx))
          else nums.update(idx, nums(idx - 1))
          verify(idx + 1, nums, count + 1)
        }
      } else verify(idx + 1, nums, count)
    }
  }
}
