package intervals.medium

object Leet56MergeIntervals {
  def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
    intervals.sortBy(_(0)).foldLeft(Array[Array[Int]]()) {
      case (result, element) =>
        if (result.isEmpty || result.last(1) < element(0)) result :+ element
        else {
          result.init :+ Array(Math.min(result.last(0), element(0)), Math.max(result.last(1), element(1)))
        }
    }
  }
}
