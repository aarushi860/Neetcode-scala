package binarySearch.easy

object Leet441ArrangingCoins {
  def arrangeCoins(n: Int): Int = {
    search(0, n, n).toInt
  }

  private def search(left: Long, right: Long, n: Int): Long = {
    if (left > right) left - 1
    else {
      val k = left + (right - left) / 2
      val sum = k * (k + 1) / 2
      sum match {
        case i if sum == n => k
        case i if (sum < n) => search(k + 1, right, n)
        case _ => search(left, k - 1, n)
      }
    }
  }
}
