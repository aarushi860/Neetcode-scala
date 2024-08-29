package heap.easy

import scala.collection.mutable

object Leet703KthLargestElementinStream {

  class KthLargest(_k: Int, _nums: Array[Int]) {
    val pq:mutable.PriorityQueue[Int]= mutable.PriorityQueue()(Ordering.Int.reverse)
    init()
    private def init():Unit={
      val counter = _nums.length - _k
      _nums.foreach(num => pq.addOne(num))
      sync(counter)
    }
    private def sync(counter:Int):Unit={
      if (counter != 0 && pq.nonEmpty)  {
        val value=pq.dequeue()
        println(s"POpping value ${value} , for counter ${counter}")
        sync(counter - 1)
      }
    }
    def add(`val`: Int): Int = {
      pq.addOne(`val`)
      sync(pq.size-_k)
      pq.head
    }
  }
}
