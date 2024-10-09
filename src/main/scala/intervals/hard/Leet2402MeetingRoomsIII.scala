package intervals.hard

import scala.collection.mutable

object Leet2402MeetingRoomsIII {
  def mostBooked(n: Int, meetings: Array[Array[Int]]): Int = {
    val ans = Array.ofDim[Int](n)
    val sorted = meetings.sorted(Ordering.by[Array[Int], Int](_.head).orElseBy(_.last))
    val meetingHeap = new mutable.PriorityQueue[(Long, Int)]()(Ordering.by[(Long, Int), Long](-_._1).orElseBy(-_._2))
    val roomsHeap = new mutable.PriorityQueue[Int]()(Ordering.Int.reverse)
     (0 until n).foreach(i => roomsHeap.addOne(i))
    sorted.foreach { interval =>
      while (meetingHeap.nonEmpty && meetingHeap.head._1 <= interval.head) {
        roomsHeap.addOne(meetingHeap.dequeue()._2)
      }
      val roomAllocated = if (roomsHeap.nonEmpty) {
        val roomNo = roomsHeap.dequeue()
        meetingHeap.addOne((interval.last, roomNo))
        roomNo
      } else {
        val lastMeeting = meetingHeap.dequeue()
        meetingHeap.addOne((lastMeeting._1 + interval.last - interval.head, lastMeeting._2))
        lastMeeting._2
      }
      //   println(s"For interval ${interval.mkString(",")} , roomAllocated $roomAllocated")
      ans.update(roomAllocated, ans(roomAllocated) + 1)
    }
    println(s"Ans ${ans.mkString(",")}")
    ans.zipWithIndex.maxBy(_._1)._2
  }
}
