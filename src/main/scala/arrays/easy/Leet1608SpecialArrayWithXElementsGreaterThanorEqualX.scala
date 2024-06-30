package arrays.easy

object Leet1608SpecialArrayWithXElementsGreaterThanorEqualX {

  def specialArray(nums: Array[Int]): Int = {
    val sorted = nums.sorted.reverse
    (0 to nums.length)
      .find(num => sorted.takeWhile(_ >= num).length == num)
      .getOrElse(-1)
  }

}
