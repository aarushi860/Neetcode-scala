package intervals.medium

import scala.collection.mutable

object Leet253MeetingRoomsII {
  def minMeetingRooms(intervals: Array[Array[Int]]): Int = {
    val sorted=intervals.sortBy(_.head)
    val pq= new mutable.PriorityQueue[Int]()(Ordering.Int.reverse)
    intervals.foreach{interval=>
      while(pq.nonEmpty && pq.head<=interval.head) {
        pq.dequeue()
      }
      println(pq.headOption)
      pq.addOne(interval.last)
    }
    pq.size
  }
}
