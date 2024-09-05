package graphs.medium

object Leet200NumberofIslands {
  def numIslands(grid: Array[Array[Char]]): Int = {
    grid.indices.map { i =>
      grid(i).indices.map { j =>
        if (grid(i)(j) == '1') {
          updateAllReachable(grid, i, j)
          1
        } else 0
      }.sum
    }.sum
  }

  private val DIRECTIONS = List((-1, 0), (0, -1), (1, 0), (0, 1))

  private def updateAllReachable(grid: Array[Array[Char]], row: Int, col: Int): Unit = {
    if (row < grid.length && row >= 0 && col < grid(0).length && col >= 0 && grid(row)(col) == '1') {
      grid(row).update(col, '2')
      DIRECTIONS.foreach(direction => updateAllReachable(grid, row + direction._1, col + direction._2))
    }
  }

}
