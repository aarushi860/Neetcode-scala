package dynamicProgramming.Two2D.medium

object Leet64MinimumPathSum {
  def minPathSum(grid: Array[Array[Int]]): Int = {
    val dp = Array.fill(grid.length, grid(0).length)(-2)

    def minimumPathSumWithDp(i: Int, j: Int): Int = {
      if (i == grid.length - 1 && j == grid(i).length - 1)
        grid(i)(j)
      else if (!grid.isDefinedAt(i) || !grid(i).isDefinedAt(j)) -1
      else if (dp(i)(j) != -2) dp(i)(j)
      else {
        val bottom = minimumPathSumWithDp(i + 1, j)
        val right = minimumPathSumWithDp(i, j + 1)
        val result = evaluate(bottom, right)+grid(i)(j)
        dp(i)(j) = result
        result
      }
    }

    minimumPathSumWithDp(0, 0)
  }

  private def evaluate(bottom: Int, right: Int) = {
    (bottom, right) match {
      case (-1, -1) => -1
      case (-1, value) => value
      case (value, -1) => value
      case (value1, value2) => Math.min(value1, value2)
    }
  }
}
