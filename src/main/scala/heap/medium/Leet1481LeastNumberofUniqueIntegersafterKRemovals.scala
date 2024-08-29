package heap.medium

import scala.collection.mutable

object Leet1481LeastNumberofUniqueIntegersafterKRemovals {
  def findLeastNumOfUniqueInts(arr: Array[Int], k: Int): Int = {
    val pq = new mutable.PriorityQueue[Int]()(Ordering.Int.reverse)
    val frequencies = arr.groupBy(identity).map(_._2.length)
    pq.addAll(frequencies)
    checkTopKElements(k, pq)
  }

  private def checkTopKElements(k: Int, pq: mutable.PriorityQueue[Int]): Int = {
    if (k == 0 || pq.isEmpty) pq.size
    else {
      val top = pq.dequeue()
      if (top > k) {
        pq.addOne(top - k)
        checkTopKElements(0, pq)
      } else checkTopKElements(k - top, pq)
    }
  }
}
