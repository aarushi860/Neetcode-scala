package dynamicProgramming.Two2D.medium

object Leet63UniquePathsII {
  def uniquePathsWithObstacles(obstacleGrid: Array[Array[Int]]): Int = {
    uniquePathsWithObstaclesWithMemo(0, 0, obstacleGrid, Array.fill(obstacleGrid.length, obstacleGrid(0).length)(-1))
  }

  private def uniquePathsWithObstaclesWithMemo(i: Int, j: Int, grid: Array[Array[Int]], memo: Array[Array[Int]]): Int = {
    if (!grid.isDefinedAt(i) || !grid(i).isDefinedAt(j) || grid(i)(j) == 1) 0
    else if (memo(i)(j) != -1) memo(i)(j)
    else if (i == grid.length - 1 && j == grid(i).length - 1) 1
    else {
      val result = uniquePathsWithObstaclesWithMemo(i + 1, j, grid, memo) + uniquePathsWithObstaclesWithMemo(i, j + 1, grid, memo)
      memo(i)(j) = result
      result
    }
  }
}
