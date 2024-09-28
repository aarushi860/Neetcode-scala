package intervals.easy

import scala.collection.mutable

object Leet252MeetingRooms {
  def canAttendMeetings(intervals: Array[Array[Int]]): Boolean = {
    val sortedIntervals = intervals.sortBy(_.head)
    val isOverlappingResult=sortedIntervals.sliding(2)
      .exists{
        case Array(first,last)=> first.last>last.head
        case _ =>false
      }
    !isOverlappingResult
  }
}
