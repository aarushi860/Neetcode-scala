package graphs.medium

import scala.collection.mutable

object Leet1162AsFarfromLandAsPossible {
  def maxDistance(grid: Array[Array[Int]]): Int = {
    val queue = new mutable.Queue[(Int, Int)]()
    val visited = new mutable.HashSet[(Int, Int)]()
    grid.indices.foreach { i =>
      grid(i).indices.foreach { j =>
        if (grid(i)(j) == 1) {
          visited.addOne((i, j))
          queue.addOne((i, j))
        }
      }
    }
    var distance = -1
    while (queue.nonEmpty) {
      val qSize = queue.size
      (0 until qSize).foreach { _ =>
        val landCell = queue.dequeue()
        DIRECTIONS.foreach { direction =>
          val row = direction.head + landCell._1
          val col = direction.last + landCell._2
          if (grid.isDefinedAt(row) && grid(row).isDefinedAt(col) && !visited.contains((row, col))) {
            queue.addOne((row, col))
            visited.addOne((row, col))

          }
        }
      }
      distance += 1
    }
    if (distance == 0) -1 else distance
  }

  val DIRECTIONS = Array(Array(-1, 0), Array(0, -1), Array(1, 0), Array(0, 1))

}
