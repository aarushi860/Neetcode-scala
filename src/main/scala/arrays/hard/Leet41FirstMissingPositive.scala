package arrays.hard

import scala.annotation.tailrec

object Leet41FirstMissingPositive {

  def firstMissingPositive(nums: Array[Int]): Int = {

    val contains1 = nums.find(_ == 1)
    if (contains1.isEmpty) 1
    else {
      preProcess(nums)
      modify(nums, 0)
      val result = getMissing(nums)
      if (result == -1) {
        if (nums(0) > 0) nums.length
        else nums.length + 1
      } else result
    }
  }

  private def getMissing(nums: Array[Int]): Int = {
    nums.tail.zipWithIndex.find(x=>x._1>0).map(_._2+1).getOrElse(-1)
  }

  @tailrec
  private def modify(nums: Array[Int], idx: Int): Unit = {
    if (idx != nums.length) {
      val value = Math.abs(nums(idx))
      if (value == nums.length)
        nums.update(0, -Math.abs(nums(0)))
      else nums.update(value, -Math.abs(nums(value)))
      modify(nums, idx + 1)
    }
  }
  private def preProcess(nums: Array[Int]): Unit = {
    nums.zipWithIndex.foreach{ x=>
      if(x._1<=0 || x._1>nums.length)
      nums.update(x._2,1)
    }
  }

}
