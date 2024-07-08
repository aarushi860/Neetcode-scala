package twoPointers.medium

object Leet18FourSum extends App{

  println(fourSum(Array(1,0,-1,0,-2,2),0))
  def fourSum(nums: Array[Int], target: Int): List[List[Int]] = {
    val k = 4
    val sorted = nums.sorted
//    println(s"Sorted ${sorted.mkString}")
    solveForKSum(k, 0, sorted, target).map(_.toList).toList
  }

  private def solveForKSum(k: Int, start: Int, nums: Array[Int], target: Long): Set[Seq[Int]] = {
    val avg = target / k
    if (start == nums.length || nums(start) > avg || nums.last < avg)
      Set()
    else {
      val result: Set[Seq[Int]] = if (k == 2) {
        twoSum(start, nums.length - 1, nums, target, Set().empty).map(x => Seq(nums(x._1), nums(x._2)))
      } else {
        (start until nums.length).flatMap { idx =>
          if (idx == start || nums(idx) != nums(idx - 1)) {
            val subsets = solveForKSum(k - 1, idx + 1, nums, target - nums(idx))
            subsets.map(subset => nums(idx) +: subset)
          } else Set()
        }
      }.toSet
      result
    }
  }


  private def twoSum(start: Int, end: Int, nums: Array[Int], target: Long, result: Set[(Int, Int)]): Set[(Int, Int)] = {
    if (start >= end) result
    else {
      val sum = nums(start) + nums(end)
      if (sum == target) {
        val updatedResult = result .+((start, end))
        val nextStart = nums.indexWhere(_ != nums(start), start + 1)
        if (nextStart != -1) twoSum(nextStart, end, nums, target, updatedResult)
        else updatedResult
      } else if (sum > target) twoSum(start, end - 1, nums, target, result)
      else twoSum(start + 1, end, nums, target, result)
    }
  }
}
