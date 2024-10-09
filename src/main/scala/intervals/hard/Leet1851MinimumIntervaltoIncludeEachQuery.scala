package intervals.hard

import scala.collection.mutable

object Leet1851MinimumIntervaltoIncludeEachQuery {
  def minInterval(intervals: Array[Array[Int]], queries: Array[Int]): Array[Int] = {
    val sortedIntervals = intervals.sortBy(_.head)
    val sortedQueries = queries.zipWithIndex.sortBy(_._1)
    implicit val ordering: Ordering[(Int, Int)] = Ordering.by[(Int, Int), Int](-_._1).orElseBy(-_._2)
    val pq = new mutable.PriorityQueue[(Int, Int)]()(ordering)
    val ans = Array.fill(queries.length)(-1)
    sortedQueries.foreach { case (query, originalIdx) =>
      val relevantINtervals = sortedIntervals.takeWhile(_.head <= query)
      relevantINtervals.foreach { interval =>
        val length = interval.last - interval.head + 1
        pq.addOne((length, interval.last))
      }
      sortedIntervals.drop(relevantINtervals.length)
      while (pq.nonEmpty && pq.head._2 < query)
        pq.dequeue()
      val top = pq.headOption.map(_._1).getOrElse(-1)
      ans(originalIdx) = if (ans(originalIdx) == -1) top else Math.min(top, ans(originalIdx))
    }
    ans
  }
}
