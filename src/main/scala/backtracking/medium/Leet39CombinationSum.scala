package backtracking.medium

object Leet39CombinationSum {
  def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
    validCombinationns(candidates, target, List(), 0)
  }

  private def validCombinationns(candidates: Array[Int], target: Int,
                                 acc: List[Int], idx: Int): List[List[Int]] = {
    if (target == 0) List(acc)
    else if (target < 0) List()
    else {
      candidates.indices.filter(_ >= idx).flatMap { i =>
        validCombinationns(candidates, target - candidates(i), acc :+ candidates(i), i)
      }.toList
    }
  }
}
