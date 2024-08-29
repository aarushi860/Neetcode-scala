package heap.medium

import scala.collection.mutable

object Leet2542MaximumSubsequenceScore {
  def maxScore(nums1: Array[Int], nums2: Array[Int], k: Int): Long = {
    val zippedNums = nums1.zip(nums2).sortBy(_._2).reverse
    val pq = new mutable.PriorityQueue[Int]()(Ordering.Int.reverse)
    val topSum = (0 until k).map { i =>
      val num1 = zippedNums(i)._1
      pq.addOne(num1)
      num1
    }.sum
    val answer = topSum * zippedNums(0)._2
    findMax(answer, zippedNums, pq, k, topSum, k)
  }

  private def findMax(answer: Long, zippedNums: Array[(Int, Int)], pq: mutable.PriorityQueue[Int],
                      k: Int, topSum: Int, idx: Int): Long = {
    if (idx == zippedNums.length) answer
    else {
      val minimum = pq.dequeue()
      val updatedSum = topSum - minimum + zippedNums(idx)._1
      pq.addOne(zippedNums(idx)._1)
      findMax(Math.max(answer, updatedSum * zippedNums(idx - k + 1)._2), zippedNums, pq, k, updatedSum, idx + 1)
    }
  }
}
