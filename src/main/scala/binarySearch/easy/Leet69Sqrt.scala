package binarySearch.easy

object Leet69Sqrt {
  def mySqrt(x: Int): Int = {
    find(0, (x / 2) + 1, x).toInt
  }

  private def find(left: Long, right: Long, x: Int): Long = {
    if (left > right) left - 1
    else {
      val mid = (left + right) / 2
      val sq = mid * mid
      sq match {
        case i if sq == x => mid
        case i if sq > x => find(left, mid - 1, x)
        case _ => find(mid + 1, right, x)
      }
    }
  }
}
