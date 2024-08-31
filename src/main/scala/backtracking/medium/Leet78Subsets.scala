package backtracking.medium

object Leet78Subsets {
  def subsets(nums: Array[Int]): List[List[Int]] = {
    find(0, nums, List(List()))
  }

  private def find(idx: Int, nums: Array[Int], subsets: List[List[Int]]): List[List[Int]] = {
    if (idx == nums.length) subsets
    else {
      find(idx + 1, nums, subsets ++ subsets.map(_ :+ nums(idx)))
    }
  }
}
