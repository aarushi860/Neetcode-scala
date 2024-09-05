package graphs.medium

object Leet695MaxAreaofIsland {
  def maxAreaOfIsland(grid: Array[Array[Int]]): Int = {
    grid.indices.flatMap { i =>
      grid(i).indices.map { j =>
        if (grid(i)(j) == 1) getArea(grid, i, j)
        else 0
      }
    }.max
  }

  private val DIRECTIONS = List((-1, 0), (0, -1), (1, 0), (0, 1))

  private def getArea(grid: Array[Array[Int]], row: Int, col: Int): Int = {
    if (grid.isDefinedAt(row) && grid(row).isDefinedAt(col) && grid(row)(col) == 1) {
      grid(row)(col) = 2
      1 + getArea(grid, row + 1, col)
      +getArea(grid, row, col + 1)
      +getArea(grid, row - 1, col)
      +getArea(grid, row, col - 1)
    } else 0
  }
}
