package arrays.easy

import scala.annotation.tailrec

object Leet724FindPivotIndex extends App {

  //  println(pivotIndex(Array(1,7,3,6,5,6)))
  println(pivotIndex(Array(2, 1, -1)))

  def pivotIndex(nums: Array[Int]): Int = {
    val totalSum = nums.sum
    getPivot(0, 0, totalSum, nums)
  }

  @tailrec
  private def getPivot(idx: Int, left: Int, total: Int, nums: Array[Int]): Int = {
    if (idx < nums.length) {
      val right = total - left - nums(idx)
      if (left == right)
        idx
      else getPivot(idx + 1, left + nums(idx), total, nums)
    } else -1
  }
}
