package backtracking.medium

object Leet46Permutations {
  def permute(nums: Array[Int]): List[List[Int]] = {
    allPermutations(nums, Set(), List())
  }

  private def allPermutations(nums: Array[Int], used: Set[Int], acc: List[Int]): List[List[Int]] = {
    if (nums.length == acc.size) List(acc)
    else {
      nums.indices.filterNot(used).flatMap { idx =>
        allPermutations(nums, used.+(idx), acc :+ nums(idx))
      }.toList
    }
  }
}
