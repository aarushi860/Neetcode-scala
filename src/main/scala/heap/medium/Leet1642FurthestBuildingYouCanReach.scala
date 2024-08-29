package heap.medium

import scala.collection.mutable

object Leet1642FurthestBuildingYouCanReach {
  def furthestBuilding(heights: Array[Int], bricks: Int, ladders: Int): Int = {
    val pq = new mutable.PriorityQueue[Int]()(Ordering.Int.reverse)
    getBuilding(0, heights, pq, bricks, ladders)
  }

  private def getBuilding(idx: Int, heights: Array[Int], pq: mutable.PriorityQueue[Int], bricks: Int, ladders: Int): Int = {
    if (idx == heights.length - 1) heights.length - 1
    else {
      val jump = heights(idx + 1) - heights(idx)
      if (jump > 0) {
        pq.addOne(jump)
        if (pq.size > ladders) {
          val top = pq.dequeue()
          val updatedBricks = bricks - top
          if (updatedBricks < 0) idx else getBuilding(idx + 1, heights, pq, updatedBricks, ladders)
        } else getBuilding(idx + 1, heights, pq, bricks, ladders)
      } else getBuilding(idx + 1, heights, pq, bricks, ladders)
    }
  }

}
