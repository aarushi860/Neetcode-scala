package graphs.medium

import scala.collection.mutable

//not working
object Leet1905CountSubIslands {
  private val DIRECTIONS = List((-1, 0), (0, -1), (1, 0), (0, 1))

  val visited = mutable.Set[(Int, Int)]()

  def countSubIslands(grid1: Array[Array[Int]], grid2: Array[Array[Int]]): Int = {
    grid2.indices.map { row =>
      grid2(row).indices.count { col =>
        grid2(row)(col) == 1 && grid1(row)(col) == 1 && !visited.contains(row, col) && isValid(row, col, grid1, grid2)
      }
    }.sum
  }

  private def isValid(row: Int, col: Int, grid1: Array[Array[Int]], grid2: Array[Array[Int]]): Boolean = {
    if (grid2.isDefinedAt(row) && grid2(row).isDefinedAt(col) && grid2(row)(col) == 1 && !visited.contains((row, col))) {
      visited.add((row, col))
      if (grid1(row)(col) == 0) false
      else {
        DIRECTIONS.forall { direction =>
          val updatedRow = direction._1 + row
          val updatedCol = direction._2 + col
          isValid(updatedRow, updatedCol, grid1, grid2)
        }
      }
    } else true
  }
}
