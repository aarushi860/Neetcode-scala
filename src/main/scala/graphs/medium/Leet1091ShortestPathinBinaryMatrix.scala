package graphs.medium

import scala.collection.mutable

object Leet1091ShortestPathinBinaryMatrix {
  private val DIRECTIONS = Array((1, 0), (0, 1), (-1, 0), (0, -1), (-1, -1), (-1, 1), (1, -1), (1, 1))

  def shortestPathBinaryMatrix(grid: Array[Array[Int]]): Int = {
    if (grid(0)(0) == 1)
      -1
    else {
      type Point = (Int, Int)
      val queue = new mutable.Queue[Point]()
      queue.addOne((0, 0))
      var found = -1
      val n = grid.length
      grid(0)(0) = 1
      while (queue.nonEmpty && found == -1) {
        val top = queue.dequeue()
        if (top._1 == n - 1 && top._2 == n - 1)
          found = grid(top._1)(top._2)
        DIRECTIONS.foreach { direction =>
          val row = top._1 + direction._1
          val col = top._2 + direction._2
          if (grid.isDefinedAt(row) && grid(row).isDefinedAt(col) && grid(row)(col) == 0) {
            grid(row)(col) = grid(top._1)(top._2) + 1
            queue.addOne((row, col))
          }
        }
      }
      found
    }
  }
}
