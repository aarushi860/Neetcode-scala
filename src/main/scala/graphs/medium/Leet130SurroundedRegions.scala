package graphs.medium

import scala.collection.mutable

//not working
object Leet130SurroundedRegions {

  private val DIRECTIONS = List((-1, 0), (0, -1), (1, 0), (0, 1))

  def solve(board: Array[Array[Char]]): Unit = {
    val pq = new mutable.Queue[(Int, Int)]()
    board.indices.foreach { row =>
      if (board(row)(0) == 'X')
        pq.addOne((row, 0))
    }
    board(0).foreach { col =>
      if (board(0)(col) == 'X')
        pq.addOne((0, col))
    }
    val m = board.length
    val n = board(0).length
    val visited = Array.ofDim[Boolean](m, n)

    while (pq.nonEmpty) {
      val queueSize = pq.size
      (1 to queueSize).foreach { _ =>
        val top = pq.dequeue()
        visited(top._1)(top._2) = true
        for (direction <- DIRECTIONS) {
          val updatedRow = direction._1 + top._1
          val updatedCol = direction._2 + top._2
          if (board.isDefinedAt(updatedRow) && board(updatedRow).isDefinedAt(updatedCol)
            && !visited(updatedRow)(updatedCol) && board(updatedRow)(updatedCol) == 'O') {
            board(updatedRow)(updatedCol) = 'X'
            pq.addOne((updatedRow, updatedCol))
          }
        }
      }
    }

  }
}
