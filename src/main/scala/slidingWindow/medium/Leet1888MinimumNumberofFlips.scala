package slidingWindow.medium

object Leet1888MinimumNumberofFlips {
  def minFlips(s: String): Int = {
    val t=s+s
    t.zipWithIndex.foldLeft(Integer.MAX_VALUE, 0, 0, 0) {
      case ((min, left, diff1, diff2), (ch, idx)) =>
        val (diff1RUpdte, diff2RUpdate) = getDifferences(diff1, diff2, ch, idx,add)
        val windowSize = idx - left + 1
        if (windowSize > s.length) {
          val (diff1LUpdate, diff2LUpdate) = getDifferences(diff1RUpdte, diff2RUpdate, t.charAt(left), left,subtract)
          (Math.min(min, Math.min(diff1LUpdate, diff2LUpdate)), left + 1, diff1LUpdate, diff2LUpdate)
        } else (min, left, diff1RUpdte, diff2RUpdate)
    }._1
  }
  private def add(x:Int): Int = x +1
  private def subtract(x:Int) = x-1
  private def getDifferences(diff1: Int, diff2: Int, ch: Char, idx: Int,fn:Int=>Int) = {
    if (idx % 2 == 0) {
      if (ch == '0') (fn(diff1), diff2)
      else (diff1, fn(diff2))
    } else {
      if (ch == '0') (diff1, fn(diff2))
      else (fn(diff1), diff2)
    }
  }

}
