package twoPointers.medium

object Leet167TwoSumIIInputArrayIsSorted {
  def twoSum(numbers: Array[Int], target: Int): Array[Int] = {
    getIndexes(0, numbers.length - 1, target, numbers)
  }

  private def getIndexes(left: Int, right: Int, target: Int, numbers: Array[Int]): Array[Int] = {
    if (left >= right)
      Array(-1, -1)
    else {
      val sum = numbers(left) + numbers(right)
      if (sum == target)
        Array(left, right)
      else if (sum > target)
        getIndexes(left, right - 1, target, numbers)
      else getIndexes(left + 1, right, target, numbers)
    }
  }
}
