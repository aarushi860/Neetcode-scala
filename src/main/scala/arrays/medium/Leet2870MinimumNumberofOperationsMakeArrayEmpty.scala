package arrays.medium

object Leet2870MinimumNumberofOperationsMakeArrayEmpty {
  def minOperations(nums: Array[Int]): Int = {
    val seq = nums.groupBy(identity).map(x => x._2.length).toSeq
    countOPeration(0, nums, seq, 0)
  }

  def countOPeration(idx: Int, nums: Array[Int], seq: Seq[Int], count: Int): Int = {
    if (idx == nums.length)
      count
    else {
      if (seq(idx) == 1)
        -1
      else countOPeration(idx + 1, nums, seq, count + Math.ceil(seq(idx).toDouble / 3).toInt)
    }
  }
}
