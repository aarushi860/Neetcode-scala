package intervals.medium

object Leet57InsertInterval {
  def insert(intervals: Array[Array[Int]], newInterval: Array[Int]): Array[Array[Int]] = {
    val (acc, last) = intervals.foldLeft(Array[Array[Int]](), newInterval) {
      case ((result, toInsert), currArrayElement) =>
        if (toInsert(1) < currArrayElement(0)) (result :+ toInsert, currArrayElement)
        else if (toInsert(0) > currArrayElement(1)) (result :+ currArrayElement, toInsert)
        else {
          (result, Array(Math.min(currArrayElement(0), toInsert(0)),
            Math.max(currArrayElement(1), toInsert(1))))
        }
    }
    acc :+ last
  }
}
