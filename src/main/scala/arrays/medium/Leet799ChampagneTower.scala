package arrays.medium

object Leet799ChampagneTower {
  def champagneTower(poured: Int, query_row: Int, query_glass: Int): Double = {

    val resultArray = Array.ofDim[Double](102, 102)
    resultArray(0)(0) = poured
    for (r <- 0 to query_row; c <- 0 to r) {
      val q = (resultArray(r)(c) - 1.0) / 2.0
      if (q > 0) {
        resultArray(r + 1)(c) += q
        resultArray(r + 1)(c + 1) += q
      }
    }

    Math.min(1, resultArray(query_row)(query_glass))
  }

}
