package twoPointers.easy

object Leet283MoveZeroes {
  def moveZeroes(nums: Array[Int]): Unit = {
    val zerPOinter = nums.indexWhere(_ == 0)
    if (zerPOinter != -1)
      swapArray(zerPOinter, nums)
  }

  private def swapArray(zeroPointer: Int, nums: Array[Int]): Unit = {
    val nonZeroIdx = nums.indexWhere(x => x != 0, zeroPointer + 1)
    if (nonZeroIdx == -1) ()
    else {
      nums.update(zeroPointer, nums(nonZeroIdx))
      nums.update(nonZeroIdx, 0)
      swapArray(zeroPointer+1, nums)
    }
  }
}
