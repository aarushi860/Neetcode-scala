package twoPointers.easy

object Leet905SortArrayByParity {

  def sortArrayByParity(nums: Array[Int]): Array[Int] = {
    nums.indices.foldLeft(-1) {
      case (oddIdx, newIdx) if nums(newIdx) % 2 == 0=>
        if (oddIdx != -1) {
          swap(nums, oddIdx, newIdx)
          oddIdx + 1
          } else oddIdx
      case (oddIdx, newIdx) => if (oddIdx == -1) newIdx else oddIdx
    }
    nums
  }

  private def swap(nums: Array[Int], oddIdx: Int, newIdx: Int): Unit = {
    val temp = nums(oddIdx)
    nums(oddIdx) = nums(newIdx)
    nums(newIdx) = temp
  }
}
