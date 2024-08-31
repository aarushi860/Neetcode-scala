package heap.hard

import scala.collection.mutable

object Leet857MinimumCostToHireKWorkers {
  def mincostToHireWorkers(quality: Array[Int], wage: Array[Int], k: Int): Double = {
    val wageRatioToQuality: Array[(Double, Int)] = wage.zip(quality).map(x => (x._1.toDouble / x._2, x._2)).sortBy(_._1)
    val pq: mutable.PriorityQueue[(Double, Int)] = new mutable.PriorityQueue[(Double, Int)]()(Ordering.by[(Double, Int), Int](_._2))
    val topKElements = wageRatioToQuality.take(k)
    pq.addAll(topKElements)
    val totalQuality = topKElements.map(_._2).sum
    calculateMin(k, k, wageRatioToQuality, totalQuality, pq, totalQuality * topKElements.last._1)

  }

  private def calculateMin(k: Int, idx: Int, wageToQualityRatio: Array[(Double, Int)], totalQuality: Int
                           , pq: mutable.PriorityQueue[(Double, Int)], min: Double
                          ): Double = {
    if (idx == wageToQualityRatio.length) min
    else {
      val topELement = pq.dequeue()
      val element = wageToQualityRatio(idx)
      val updatedQuality = totalQuality + element._2 - topELement._2
      val updatedMin = Math.min(updatedQuality * element._1, min)
      pq.addOne(element)
      calculateMin(k, idx + 1, wageToQualityRatio, updatedQuality, pq, updatedMin)
    }
  }

}
