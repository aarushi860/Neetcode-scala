package heap.medium

import scala.collection.mutable

object Leet1985FindtheKthLargestIntegerintheArray {
  def kthLargestNumber(nums: Array[String], k: Int): String = {
    val pq = mutable.PriorityQueue[(String, Int)]()(CustomOrdering)
    nums.zipWithIndex.foreach(x => pq.addOne(x))
    (1 until k).foreach(_ => pq.dequeue())

    pq.dequeue()._1
  }

  object CustomOrdering extends Ordering[(String, Int)] {
    override def compare(x: (String, Int), y: (String, Int)): Int = {
      if (x._1 == y._1) x._2 compare y._2
      else BigInt(x._1) compare BigInt(y._1)
    }
  }
}
