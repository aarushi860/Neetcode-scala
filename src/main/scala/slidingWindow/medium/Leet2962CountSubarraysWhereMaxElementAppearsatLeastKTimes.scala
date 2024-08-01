package slidingWindow.medium

object Leet2962CountSubarraysWhereMaxElementAppearsatLeastKTimes {
  def countSubarrays(nums: Array[Int], k: Int): Long = {
    val max = nums.max
    nums.zipWithIndex.foldLeft(0L, 0, 0) {
      case ((totalCount, left, fq), (num, idx)) =>
        val updatedFq = if (num == max) fq + 1 else fq
        val (updatedLeft, minFq) = getUpdateMin(left, max, updatedFq, k, nums)
        (totalCount + updatedLeft, updatedLeft, minFq)
    }._1
  }

  private def getUpdateMin(left: Int, max: Int, fq: Int, k: Int
                           , nums: Array[Int]): (Int, Int) = {
    if (fq == k) {
      if (nums(left) != max)
        getUpdateMin(left + 1, max, fq, k, nums)
      else getUpdateMin(left + 1, max, fq - 1, k, nums)
    }
    else (left, fq)
  }


}
