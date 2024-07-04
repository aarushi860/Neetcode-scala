package arrays.medium

object Leet442FindAllDuplicatesinArray {
  def findDuplicates(nums: Array[Int]): List[Int] = {
    getDuplicates(List(), nums, 0)
  }

  def getDuplicates(list: List[Int], nums: Array[Int], idx: Int): List[Int] = {
    if (idx == nums.length)
      list
    else {
      val idxTo = nums(idx)
      val value = Math.abs(idxTo) - 1
      if (value < 0)
        getDuplicates(list :+ idxTo, nums, idx + 1)
      else {
        nums.update(idxTo, -value)
        getDuplicates(list, nums, idx)
      }
    }
  }
}
