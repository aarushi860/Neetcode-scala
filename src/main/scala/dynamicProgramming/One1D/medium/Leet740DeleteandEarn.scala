package dynamicProgramming.One1D.medium

object Leet740DeleteandEarn {
  def deleteAndEarn(nums: Array[Int]): Int = {
    val freq = nums.groupBy(identity).map(x => (x._1, x._2.length * x._1))
    val memo = Array.fill(nums.max + 1)(-1)
    getMax(nums.max, freq, 0, memo)
  }

  def getMax(number: Int, freq: Map[Int, Int], sum: Int, memo: Array[Int]): Int = {
    if (number <= 0) sum
    else if (memo(number) != -1) memo(number)
    else {
      val currentTaken = freq.getOrElse(number, 0)
      memo(number) = Math.max(getMax(number - 1, freq, sum, memo),
        currentTaken + getMax(number - 2, freq, sum, memo))
      memo(number)
    }
  }

}
