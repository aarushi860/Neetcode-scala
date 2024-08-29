package heap.easy

import scala.collection.mutable

object Leet1046LastStoneWeight {
  def lastStoneWeight(stones: Array[Int]): Int = {
    val pq = new mutable.PriorityQueue[Int]()
    pq.addAll(stones)
    play(pq)
  }

  private def play(pq: mutable.PriorityQueue[Int]): Int = {
    if (pq.size >= 2) {
      val x = pq.dequeue()
      val y = pq.dequeue()
      val result = Math.abs(x - y)
      if (result != 0) pq.addOne(result)
      play(pq)
    }
    else if (pq.size == 1)
      pq.dequeue()
    else 0
  }
}
