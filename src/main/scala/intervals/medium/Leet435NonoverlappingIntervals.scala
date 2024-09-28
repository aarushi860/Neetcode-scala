package intervals.medium

import scala.collection.mutable

object Leet435NonoverlappingIntervals {
  def eraseOverlapIntervals(intervals: Array[Array[Int]]): Int = {
    intervals.sortBy(_(1)).foldLeft(Integer.MIN_VALUE, 0) {
      case ((last, count), currentInterval) =>
        if (currentInterval(0) >= last) (currentInterval(1), count)
        else (last, count + 1)
    }._2
  }


}
