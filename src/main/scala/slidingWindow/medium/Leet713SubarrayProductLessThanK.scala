package slidingWindow.medium

object Leet713SubarrayProductLessThanK {
  def numSubarrayProductLessThanK(nums: Array[Int], k: Int): Int = {
    nums.zipWithIndex.foldLeft(0, 1, 0) {
      case ((count, product, left), (num, idx)) =>
        val (updatedLeft, updatedProduct) = getMinLeft(left, product * num, idx, nums, k)
        (count + idx - updatedLeft + 1, updatedProduct, updatedLeft)
    }._1
  }

  private def getMinLeft(left: Int, product: Int, idx: Int, nums: Array[Int], k: Int): (Int, Int) = {
    if (product < k || left > idx)
      (left, product)
    else getMinLeft(left + 1, product / nums(left), idx, nums, k)
  }


}
