package heap.medium

import scala.collection.mutable

object Leet767ReorganizeString {
  def reorganizeString(s: String): String = {
    val charWithFq = s.groupBy(identity).map(x => (x._1, x._2.length))
    val pq = new mutable.PriorityQueue[(Char, Int)]()(Ordering.by[(Char, Int), Int](_._2))
    pq.addAll(charWithFq)
    constructString("", pq)
  }

  private def constructString(result: String, pq: mutable.PriorityQueue[(Char, Int)]): String = {
    if (pq.isEmpty) result
    else {
      val topElements = (1 to 2).flatMap { _ =>
        if (pq.nonEmpty) Some(pq.dequeue())
        else None
      }
      if (result.nonEmpty && result.last == topElements.head._1) {
        ""
      } else {
        val updatedElements = topElements.map(x => (x._1, x._2 - 1)).filterNot(_._2 == 0)
        pq.addAll(updatedElements)
        constructString(result + topElements.map(_._1).mkString, pq)
      }
    }
  }


}
