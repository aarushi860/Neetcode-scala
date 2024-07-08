package twoPointers.medium

object Leet15ThreeSum {

  def threeSum(nums: Array[Int]): List[List[Int]] = {
    val sorted = nums.sorted
    sorted.takeWhile(_ <= 0).indices.foldLeft(Set[List[Int]]()) {
      case (result, idx) if idx == 0 || sorted(idx) != sorted(idx - 1) =>
        result ++ getTwoSum(sorted, sorted(idx), idx + 1,
          sorted.length - 1, List())
          .map(x => List(sorted(idx), sorted(x._1), sorted(x._2)))
      case other => other._1
    }.toList
  }

  private def getTwoSum(sorted: Array[Int], target: Int, start: Int,
                        end: Int, result: List[(Int, Int)]): List[(Int, Int)] = {
    if (start >= end) result
    else {
      val sum = sorted(start) + sorted(end)
      if ((sum + target) == 0) {
        val ans = (start, end)
        val updatedResult = result :+ ans
        val nextStart = sorted.indexWhere(_ != sorted(start), start + 1)
        if (nextStart == -1)
          updatedResult
        else getTwoSum(sorted, target, nextStart, end, updatedResult)
      }
      else if (sum + target > 0)
        getTwoSum(sorted, target, start, end - 1, result)
      else getTwoSum(sorted, target, start + 1, end, result)
    }
  }
}
