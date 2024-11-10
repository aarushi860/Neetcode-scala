package backtracking.medium

object Leet90SubsetsII {
  def subsetsWithDup(nums: Array[Int]): List[List[Int]] = {
    nums.sorted.foldLeft(Set(List[Int]())) {
      case (set, num) => set ++ set.map(_ :+ num)
    }.toList
  }
}
