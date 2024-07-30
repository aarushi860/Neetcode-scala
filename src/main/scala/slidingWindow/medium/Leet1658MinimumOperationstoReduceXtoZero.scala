package slidingWindow.medium

object Leet1658MinimumOperationstoReduceXtoZero {
  def minOperations(nums: Array[Int], x: Int): Int = {
    val sum = nums.sum - x

    val max = nums.zipWithIndex.foldLeft(-1, 0, 0) {
      case ((max, currSum, left), (num, idx)) =>
        val (updatedLeft, updatedSum) = getMin(left, currSum + num, nums, idx, sum)
        val updatedMax = if (updatedSum == sum) Math.max(max, idx - updatedLeft + 1) else max
        (updatedMax, updatedSum, updatedLeft)
    }._1
    if (max == -1) -1 else nums.length - max
  }

  private def getMin(left: Int, currSum: Int, nums: Array[Int], right: Int, target: Int): (Int, Int) = {
    if (currSum > target && left <= right)
      getMin(left + 1, currSum - nums(left), nums, right, target)
    else (left, currSum)
  }
}
