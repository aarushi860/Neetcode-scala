package slidingWindow.hard

import scala.collection.mutable

object Leet239SlidingWindowMaximum {
  def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int] = {
    val dequeue = mutable.ArrayDeque.empty[Int]
    nums.indices.map { idx =>
      dequeue.removeLastWhile(i => nums(idx) > nums(i))
      dequeue.removeHeadWhile(i => idx + k == i)
      dequeue.addOne(idx)
      dequeue.head
    }.toArray
  }
}
