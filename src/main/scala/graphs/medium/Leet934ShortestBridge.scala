package graphs.medium

import scala.collection.mutable

object Leet934ShortestBridge {
  def shortestBridge(grid: Array[Array[Int]]): Int = {
    val row = grid.indexWhere(arr => arr.contains(1))
    val col = grid(row).indexWhere(_ == 1)
    val queue = new mutable.Queue[(Int, Int, Int)]()
    getIslandLength(queue, grid)
  }

  private val DIRECTIONS = Seq((-1, 0), (0, -1), (1, 0), (0, 1))

  private def getIslandLength(queue: mutable.Queue[(Int, Int, Int)], grid: Array[Array[Int]]) = {
    var found = -1
    while (queue.nonEmpty && found == -1) {
      val top = queue.dequeue()
      DIRECTIONS.foreach { direction =>
        val updatedRow = top._1 + direction._1
        val updatedCol = top._2 + direction._2
        if (grid.isDefinedAt(updatedRow) && grid(updatedRow).isDefinedAt(updatedCol) && grid(updatedRow)(updatedCol)!=2) {
          if (grid(updatedRow)(updatedCol) == 1)
            found = top._3
          else queue.addOne((updatedRow, updatedCol, top._3 + 1))
        }
      }
    }
    found
  }


  private def paintDfs(grid: Array[Array[Int]], row: Int, col: Int, queue: mutable.Queue[(Int, Int, Int)]): Unit = {
    if (grid(row)(col) == 1) {
      grid(row)(col) = 2
      queue.addOne((row, col, 0))
      DIRECTIONS.foreach { direction =>
        val updatedRow = row + direction._1
        val updatedCol = col + direction._2
        if (grid.isDefinedAt(updatedRow) && grid(updatedRow).isDefinedAt(updatedCol))
          paintDfs(grid, updatedRow, updatedCol, queue)
      }
    }
  }
}
