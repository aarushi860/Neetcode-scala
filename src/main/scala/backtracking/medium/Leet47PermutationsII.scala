package backtracking.medium

object Leet47PermutationsII {
  def permuteUnique(nums: Array[Int]): List[List[Int]] = {
    allPermutations(nums, Set(), List()).toList
  }

  private def allPermutations(nums: Array[Int], used: Set[Int], acc: List[Int]): Set[List[Int]] = {
    if (nums.length == acc.size) Set(acc)
    else {
      nums.indices.filterNot(used).flatMap { idx =>
        allPermutations(nums, used.+(idx), acc :+ nums(idx))
      }.toSet
    }
  }
}
