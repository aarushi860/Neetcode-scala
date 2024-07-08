package twoPointers.medium

object Leet2149RearrangeArrayElementsbySign {
  def rearrangeArray(nums: Array[Int]): Array[Int] = {
    val (negative, positive) = nums.partition(_ < 0)
    positive.zip(negative).flatMap(x => Array(x._1, x._2))
  }
}
