package dynamicProgramming.Two2D.medium

object Leet62UniquePaths {

  def uniquePaths(m: Int, n: Int): Int = {
    uniquePathsWithMemo(0, 0, m, n, Array.fill(m, n)(-1))
  }

  private def uniquePathsWithMemo(i: Int, j: Int, m: Int, n: Int, memo: Array[Array[Int]]): Int = {
    if (i >= m || j >= n) 0
    else if (memo(i)(j) != -1) memo(i)(j)
    else if (i == m - 1 && j == n - 1) 1
    else {
      val result = uniquePathsWithMemo(i + 1, j, m, n, memo) + uniquePathsWithMemo(i, j + 1, m, n, memo)
      memo(i)(j) = result
      result
    }
  }


}
