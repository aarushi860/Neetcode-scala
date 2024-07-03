package arrays.medium

object Leet1685SumofAbsoluteDifferencesinSortedArray {
  def getSumAbsoluteDifferences(nums: Array[Int]): Array[Int] = {
    getSum(nums.sum, 0, 0, nums, Array.ofDim(nums.length))
  }

  private def getSum(totalSum: Int, prevSum: Int, idx: Int, nums: Array[Int], result: Array[Int]): Array[Int] = {
    if (idx == nums.length)
      result
    else {
      val num = nums(idx)
      val sum = idx * num - prevSum + totalSum - prevSum - (nums.length - idx) * num
      result.update(idx, sum)
      getSum(totalSum, prevSum + num, idx + 1, nums, result)
    }
  }
}
