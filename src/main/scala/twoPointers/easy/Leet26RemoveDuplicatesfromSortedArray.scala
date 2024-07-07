package twoPointers.easy

object Leet26RemoveDuplicatesfromSortedArray {

  def removeDuplicates(nums: Array[Int]): Int = {
    if (nums.length == 1)
      1
    else {
      nums.indices.tail.foldLeft((nums.head, 0)) {
        case ((lastNum, idxLast), newIdx) if nums(newIdx) > lastNum =>
          val idxToUpdate = idxLast + 1
          nums.update(idxToUpdate, nums(newIdx))
          (nums(idxToUpdate), idxToUpdate)
        case other => other._1
      }._2+ 1
    }
  }
}
