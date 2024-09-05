package graphs.medium

import scala.collection.mutable

object Leet286WallsandGates {

  private val DIRECTIONS = List((-1, 0), (0, -1), (1, 0), (0, 1))

  def wallsAndGates(rooms: Array[Array[Int]]): Unit = {
    val queue = new mutable.Queue[(Int, Int)]()
    rooms.indices.map { row =>
      rooms(row).indices.map { col =>
        if (rooms(row)(col) == 0) {
          queue.addOne((row, col))
        }
      }
    }

    while (queue.nonEmpty) {
      val (row, col) = queue.dequeue()
      for (direction <- DIRECTIONS) {
        val updatedRow = direction._1 + row
        val updatedCol = direction._2 + col
        if (rooms.isDefinedAt(updatedRow) && rooms(updatedRow).isDefinedAt(updatedCol) && rooms(updatedRow)(updatedCol) == Integer.MAX_VALUE) {
          rooms(updatedRow)(updatedCol) = rooms(row)(col) + 1
          queue.addOne((updatedRow, updatedCol))
        }
      }
    }
  }

}
