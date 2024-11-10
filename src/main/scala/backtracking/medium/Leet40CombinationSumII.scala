package backtracking.medium

//not working
object Leet40CombinationSumII {
  def combinationSum2(candidates: Array[Int], target: Int): List[List[Int]] = {
    combinations(candidates.sorted, target, 0, List()).toList
  }

  private def combinations(candidates: Array[Int], target: Int, idx: Int, acc: List[Int]): Set[List[Int]] = {
    if (target == 0) Set(acc)
    else if (target < 0 || idx == candidates.length) Set()
    else {
      candidates.indices.filter(_ >= idx).flatMap { i =>
        combinations(candidates, target - candidates(i), i + 1, acc :+ candidates(i))
      }.toSet
    }
  }
}
