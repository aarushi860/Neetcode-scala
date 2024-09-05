package graphs.easy

object Leet463IslandPerimeter {
  def islandPerimeter(grid: Array[Array[Int]]): Int = {
    grid.indices.map { row =>
      grid(row).indices.map { col =>
        if (grid(row)(col) == 1) {
          val up = if (row > 0 && grid(row - 1)(col) == 1) -2 else 0
          val left = if (col > 0 && grid(row)(col - 1) == 1) -2 else 0
          4 + up + left
        } else 0
      }.sum
    }.sum
  }
}
