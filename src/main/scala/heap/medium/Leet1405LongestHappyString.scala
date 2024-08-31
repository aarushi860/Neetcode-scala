package heap.medium

import scala.collection.mutable

object Leet1405LongestHappyString {
  def longestDiverseString(a: Int, b: Int, c: Int): String = {
    val pq = new mutable.PriorityQueue[(Char, Int)]()(Ordering.by[(Char, Int), Int](_._2))
    if (a != 0) pq.addOne('a', a)
    if (b != 0) pq.addOne('b', b)
    if (c != 0) pq.addOne('c', c)
    constructString(pq, "")
  }

  private def constructString(pq: mutable.PriorityQueue[(Char, Int)], result: String): String = {
    if (pq.isEmpty) result
    else if (pq.size == 1) {
      val top = pq.dequeue()
      if ((result.nonEmpty && result.last != top._1)|| result.isEmpty) {
        if (top._2 >= 2) s"$result${top._1}${top._1}"
        else s"$result${top._1}"
      } else result
    }
    else {
      val firstElement = pq.dequeue()
      val secondElement = pq.dequeue()
      val (firstStr, firstFq) = if (firstElement._2 > 1) (s"${firstElement._1}${firstElement._1}", firstElement._2 - 2)
      else (s"${firstElement._1}", firstElement._2 - 1)
      val (secondStr, secondFq) = if (secondElement._2 > 1 && secondElement._2 >= firstElement._2)
        (s"${secondElement._1}${secondElement._1}", secondElement._2 - 2)
      else (s"${secondElement._1}", secondElement._2 - 1)

      if (firstFq != 0)
        pq.addOne((firstElement._1, firstFq))
      if (secondFq != 0)
        pq.addOne((secondElement._1, secondFq))
      constructString(pq, result + firstStr + secondStr)
    }
  }
}
