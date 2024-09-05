package graphs.medium

import scala.collection.mutable

object Leet994RottingOranges {
  def orangesRotting(grid: Array[Array[Int]]): Int = {
    val rottenQueue = new mutable.Queue[(Int, Int)]()
    var freshCount = 0;
    grid.indices.map { row =>
      grid(row).indices.map { col =>
        if (grid(row)(col) == 2)
          rottenQueue.addOne((row, col))
        else if (grid(row)(col) == 1)
          freshCount += 1
      }
    }
    val DIRECTIONS = List((-1, 0), (0, -1), (1, 0), (0, 1))

    var time = 0;
    while (rottenQueue.nonEmpty) {
      val queueSize = rottenQueue.size
      var freshPresent = false
      (1 to queueSize).foreach { _ =>
        val (row, col) = rottenQueue.dequeue()
        for (direction <- DIRECTIONS) {
          val updatedRow = direction._1 + row
          val updatedCol = direction._2 + col
          if (grid.isDefinedAt(updatedRow) && grid(updatedRow).isDefinedAt(updatedCol) && grid(updatedRow)(updatedCol) == 1) {
            grid(updatedRow)(updatedCol) = 2
            freshCount -= 1
            freshPresent = true
            rottenQueue.addOne((updatedRow, updatedCol))
          }
        }
      }
      if (freshPresent) time += 1

    }

    if (freshCount == 0) time else -1
  }


}
