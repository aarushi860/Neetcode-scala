package intervals.medium

object Leet1288RemoveCoveredIntervals {
  def removeCoveredIntervals(intervals: Array[Array[Int]]): Int = {
    implicit val ordering:Ordering[Array[Int]]=Ordering
      .by[Array[Int],Int](_.head).orElseBy(-_.last)
    val sorted = intervals.sorted(ordering)
    sorted.tail.foldLeft(Array[Array[Int]](sorted.head)) {
      case (result, current) =>
        if (result.isEmpty || !isCovered(result.last, current)) result :+ current
        else result
    }.length
  }

  private def isCovered(first: Array[Int], last: Array[Int]): Boolean = {
    first.head <= last.head && first.last >= last.last
  }
}
