package heap.hard

import scala.collection.mutable

object Leet1383MaximumPerformanceofaTeam {
  def maxPerformance(n: Int, speed: Array[Int], efficiency: Array[Int], k: Int): Int = {
    val speedWithEfficiency = speed.zip(efficiency).sortBy(_._2)(Ordering.Int.reverse)
    val pq = mutable.PriorityQueue[(Int, Int)]()(Ordering.by[(Int, Int), Int](_._1).reverse)
    (getMax(0, pq, 0, k, speedWithEfficiency, 0)% (Math.pow(10,9)+7).toInt).toInt
  }

  private def getMax(maxPerformance: Long, pq: mutable.PriorityQueue[(Int, Int)]
                     , idx: Int, k: Int, speedEfficiency: Array[(Int, Int)], sum: Long): Long = {
    if (idx == speedEfficiency.length) maxPerformance
    else {
      val toInsert = speedEfficiency(idx)
      pq.addOne(toInsert)
      val updatedSum = sum + toInsert._1
      val performanceUpdated = Math.max(maxPerformance,updatedSum * toInsert._2)
      val newSum = if (pq.size == k) {
        updatedSum - pq.dequeue()._1
      } else updatedSum
      getMax(performanceUpdated, pq, idx + 1, k, speedEfficiency, newSum)
    }
  }
}
