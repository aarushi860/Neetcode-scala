package arrays.easy

object Leet1913MaximumProductDifferenceBetweenTwoPairs extends App {
  def maxProductDifference(nums: Array[Int]): Int = {
    val (max1, max2) = getMax(nums)
    val (min1, min2) = getMin(nums)
    max1 * max2 - min1 * min2
  }

  def getMax(nums: Array[Int]) = {
    nums.foldLeft((0, 0))((max, num) => if (num > max._1) (num, max._1)
    else (max._1, math.max(num, max._2)))
  }
  def getMin(nums: Array[Int]) = {
    nums.foldLeft((Integer.MAX_VALUE, Integer.MAX_VALUE))((min, num) => if (num < min._1) (num, min._1)
    else (min._1, math.min(num, min._2)))
  }
  //  println(maxProductDifference(Array(1, 6, 7, 5, 2, 4, 10, 6, 4)))
  println(maxProductDifference(Array(8, 3, 5, 7)))
}
