package graphs.medium

import scala.collection.mutable

object Leet417PacificAtlanticWaterFlow {
  def pacificAtlantic(heights: Array[Array[Int]]): List[List[Int]] = {
    val pacificQueue = mutable.Queue[IslandHeight]()
    val altanticQueue = mutable.Queue[IslandHeight]()
    val rowLength = heights.length
    val colLength = heights(0).length
    pacificQueue.addAll(heights(0).indices.map(i => IslandHeight(0, i, heights(0)(i))))
    pacificQueue.addAll(heights.indices.map(i => IslandHeight(i, 0, heights(i)(0))))
    altanticQueue.addAll(heights(rowLength - 1).indices.map(i => IslandHeight(rowLength - 1, i, heights(rowLength - 1)(i))))
    altanticQueue.addAll(heights.indices.map(i => IslandHeight(i, colLength - 1, heights(i)(colLength - 1))))
    val pacificVisited = verifyHeights(pacificQueue, heights, Array.ofDim[Boolean](rowLength, colLength))
    val atlanticVisited = verifyHeights(altanticQueue, heights, Array.ofDim[Boolean](rowLength, colLength))
    val result = pacificVisited.indices.flatMap { row =>
      val cols = pacificVisited(row).indices.filter { col =>
        pacificVisited(row)(col) && atlanticVisited(row)(col)
      }
      cols.map(y => List(row, y))
    }.toList
    result
  }

  private val DIRECTIONS = List((-1, 0), (0, -1), (1, 0), (0, 1))

  private def verifyHeights(queue: mutable.Queue[IslandHeight], heights: Array[Array[Int]], visited: Array[Array[Boolean]]) = {
    while (queue.nonEmpty) {
      val top = queue.dequeue()
      visited(top.row)(top.col) = true
      for (direction <- DIRECTIONS) {
        val updatedRow = direction._1 + top.row
        val updatedCol = direction._2 + top.col
        if (heights.isDefinedAt(updatedRow) && heights(updatedRow).isDefinedAt(updatedCol) && !visited(updatedRow)(updatedCol) && top.height <= heights(updatedRow)(updatedCol)) {
          queue.addOne(IslandHeight(updatedRow, updatedCol, heights(updatedRow)(updatedCol)))
        }
      }
    }
    visited
  }

  case class IslandHeight(row: Int, col: Int, height: Int)
}
