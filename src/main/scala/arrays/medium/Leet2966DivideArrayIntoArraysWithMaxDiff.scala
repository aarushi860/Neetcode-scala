package arrays.medium

class Leet2966DivideArrayIntoArraysWithMaxDiff {
  def divideArray(nums: Array[Int], k: Int): Array[Array[Int]] = {
    val sortedNums = nums.sorted
    val group= sortedNums.grouped(3).toSeq
    val isValid = group.forall(x => (x.last - x.head) <= k)
    if (isValid) group.map(_.toArray).toArray
    else Array.empty
  }
}
