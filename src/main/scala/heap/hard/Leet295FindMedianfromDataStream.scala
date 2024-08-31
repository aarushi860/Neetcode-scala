package heap.hard

import scala.collection.mutable

object Leet295FindMedianfromDataStream {
  class MedianFinder() {
    val maxHeap = new mutable.PriorityQueue[Int]()
    val minHeap = new mutable.PriorityQueue[Int]()(Ordering.Int.reverse)

    def addNum(num: Int): Unit = {
      maxHeap.addOne(num)
      minHeap.addOne(maxHeap.dequeue())
      if (minHeap.size > maxHeap.size) maxHeap.addOne(minHeap.dequeue())
    }

    def findMedian(): Double = {
      if (minHeap.size == maxHeap.size && maxHeap.nonEmpty) {
        (minHeap.head + maxHeap.head) / 2.0
      } else maxHeap.head
    }

  }
}
