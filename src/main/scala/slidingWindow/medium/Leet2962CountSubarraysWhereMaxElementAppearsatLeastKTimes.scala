package slidingWindow.medium

object Leet2962CountSubarraysWhereMaxElementAppearsatLeastKTimes {
  def countSubarrays(nums: Array[Int], k: Int): Long = {
    val max = nums.max
    nums.zipWithIndex.foldLeft(0, 0, 0) {
      case ((count, left, fq), (num, idx)) =>
        if (num == max) {
          if (fq == k - 1) {
            val updatedLeft = getStart(left, idx, nums, max)
            (count + updatedLeft + 1, updatedLeft + 1, fq)
          }
          else (count, left, fq + 1)
        } else (count, left, fq)
    }._1
  }

  private def getStart(left: Int, idx: Int, nums: Array[Int], max: Int): Int = {
    if (left == max)
      left
    else getStart(left + 1, idx, nums, max)
  }

}
