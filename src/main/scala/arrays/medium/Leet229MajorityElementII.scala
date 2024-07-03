package arrays.medium

import scala.collection.mutable

object Leet229MajorityElementII {
  def majorityElement(nums: Array[Int]): List[Int] = {
    val (candidate1, candidate2) = getCandidates(None, None, 0, 0, 0, nums)
    val result: mutable.ListBuffer[Int] = mutable.ListBuffer.empty
    val count1 = if (candidate1.isEmpty) 0 else nums.count(_ == candidate1.get)
    // println(s"candidate1 $candidate1, count is $count1")
    if ((nums.length / 3) < count1) result.addOne(candidate1.get)
    val count2 = if (candidate2.isEmpty) 0 else nums.count(_ == candidate2.get)
    // println(s"candidate2 $candidate2, count is $count2")
    if ((nums.length) / 3 < count2) result.addOne(candidate2.get)
    result.toList
  }

  private def getCandidates(candidate1: Option[Int]
                            , candidate2: Option[Int]
                            , count1: Int
                            , count2: Int
                            , idx: Int
                            , nums: Array[Int]
                           ): (Option[Int], Option[Int]) = {
    if (idx == nums.length)
      (candidate1, candidate2)
    else {
      val x = nums(idx)
      if (candidate1.isDefined && x == candidate1.get) {
        getCandidates(candidate1, candidate2, count1 + 1, count2, idx + 1, nums)
      } else if (candidate2.isDefined && x == candidate2.get) {
        getCandidates(candidate1, candidate2, count1, count2 + 1, idx + 1, nums)
      } else if (candidate1.isEmpty || count1 == 0)
        getCandidates(Some(x), candidate2, count1 + 1, count2, idx + 1, nums)
      else if (candidate2.isEmpty || count2 == 0)
        getCandidates(candidate1, Some(x), count1, count2 + 1, idx + 1, nums)
      else {
        getCandidates(candidate1, candidate2, count1 - 1, count2 - 1, idx + 1, nums)
      }
    }
  }
}
