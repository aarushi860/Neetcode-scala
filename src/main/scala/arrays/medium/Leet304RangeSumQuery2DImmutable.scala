package arrays.medium

class Leet304RangeSumQuery2DImmutable(_matrix: Array[Array[Int]]) {

  val dp: Array[Array[Int]] = preProcess

  private def preProcess = {
    if (_matrix.length > 0 && _matrix.head.length > 0) {
      val dp = Array.ofDim[Int](_matrix.length + 1, _matrix.head.length + 1)
      for (r <- 1 to _matrix.length; c <- 1 to _matrix.head.length) {
        dp(r)(c) = dp(r - 1)(c) + dp(r)(c - 1) - dp(r - 1)(c - 1) + _matrix(r - 1)(c - 1)
      }
      dp
    } else _matrix
  }

  def sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int = {
    dp(row2 + 1)(col2 + 1) - dp(row1 + 1 - 1)(col2 + 1) - dp(row2 + 1)(col1 + 1 - 1) + dp(row1 + 1 - 1)(col1 + 1 - 1)
  }
}
