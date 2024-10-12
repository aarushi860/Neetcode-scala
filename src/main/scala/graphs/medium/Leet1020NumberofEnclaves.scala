package graphs.medium

import scala.collection.mutable

object Leet1020NumberofEnclaves {
  def numEnclaves(grid: Array[Array[Int]]): Int = {
    val visited = new mutable.HashSet[(Int, Int)]()
    grid.indices.foreach { i =>
        grid(i).indices.foreach { j =>
          if (i==0 || i==grid.length-1 || j == 0 || j == grid(i).length - 1) {
            if (grid(i)(j) == 1 && !visited.contains(i, j))
              dfs(i, j, grid, visited)
          }
        }
    }
    grid.indices.map(i => grid(i).indices.count(j => grid(i)(j) == 1)).sum
  }

  val DIRECTIONS = List((-1, 0), (0, -1), (0, 1), (1, 0))

  private def dfs(i: Int, j: Int, grid: Array[Array[Int]], visited: mutable.Set[(Int, Int)]): Unit = {
    if (grid.isDefinedAt(i) && grid(i).isDefinedAt(j) && !visited.contains(i, j)) {
      visited.addOne((i, j))
      if (grid(i)(j) == 1) {
        grid(i)(j) = 2
        DIRECTIONS.foreach { direction =>
          val row = direction._1 + i
          val col = direction._2 + j
          dfs(row, col, grid, visited)
        }
      }
    }
  }

}
