package heap.hard

import scala.collection.mutable

object Leet502IPO {
  def findMaximizedCapital(k: Int, w: Int, profits: Array[Int], capital: Array[Int]): Int = {
    val profitsAndCapital = profits.zip(capital).sortBy(_._2)
    val pq = mutable.PriorityQueue[Int]()
    calculateProfit(w, k, pq, 0, profitsAndCapital)
  }

  private def calculateProfit(w: Int, k: Int, pq: mutable.PriorityQueue[Int], idx: Int,
                              profitsAndCapital: Array[(Int, Int)]): Int = {
    if (idx == k) w
    else {
      val pointer = profitsAndCapital.lastIndexWhere(_._2 <= w)
      if (pointer == -1 && pq.isEmpty) w
      else {
        val profitsTOAdd = profitsAndCapital.take(pointer + 1)
        pq.addAll(profitsTOAdd.map(_._1))
        val updatedW = if (pq.nonEmpty) w + pq.dequeue() else w
        calculateProfit(updatedW, k, pq, idx + 1, profitsAndCapital.drop(pointer + 1))
      }
    }
  }
}
