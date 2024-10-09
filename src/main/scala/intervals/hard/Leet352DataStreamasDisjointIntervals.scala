package intervals.hard

import scala.collection.mutable

object Leet352DataStreamasDisjointIntervals {
  class SummaryRanges() {

    val treeMap: mutable.TreeMap[Int, Int] = mutable.TreeMap.empty

    def addNum(value: Int): Unit = {
      if (!treeMap.contains(value)) {
        val leftSideMap = treeMap.maxBefore(value)
        if (!(leftSideMap.isDefined && leftSideMap.get._2 >= value)) {
          val left = if (leftSideMap.isDefined && leftSideMap.get._2==value-1) leftSideMap.get._1 else value
          val right = if (treeMap.contains(value + 1)) {
            val next = treeMap(value + 1)
            treeMap.remove(value + 1)
            next
          } else value
          println(s"For value $value, left $left right $right")
          treeMap.put(left, right)
        }
      }
    }

    def getIntervals(): Array[Array[Int]] = {
      treeMap.map(x => Array(x._1, x._2)).toArray
    }
  }

}
