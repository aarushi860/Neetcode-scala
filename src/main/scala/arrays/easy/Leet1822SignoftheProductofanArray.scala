package arrays.easy

object Leet1822SignoftheProductofanArray {
  def arraySign(nums: Array[Int]): Int = {
    val zeroPresent = nums.find(_ == 0)
    if (zeroPresent.isDefined) 0
    else {
      val negativeCount = nums.count(_ < 0)
      if (negativeCount % 2 == 1) -1
      else 1
    }
  }


}
