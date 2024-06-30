package arrays.medium

object Leet2017GridGame {
  def gridGame(grid: Array[Array[Int]]): Long = {
    val topsum = grid(0).sum.toLong
    val idx = 0
    val bottomSum = 0L
    val ans = Long.MaxValue
    grid(0).foldLeft((idx, topsum, bottomSum, ans)) {
      case ((idx, topsum, bottomSum, ans), element) =>

        val newAns = Math.min(ans, Math.max(topsum - element, bottomSum))
        (idx + 1, topsum - element, bottomSum + grid(1)(idx), newAns)
    }._4
  }
}
