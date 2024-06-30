package arrays.medium

object Leet1963MinimumNumberofSwapstoMakeStringBalanced {
  def minSwaps(s: String): Int = {
    val count = s.foldLeft(0, 0) {
      case ((max, curr), ch) =>
        val updatedCurr = if (ch == '[') curr - 1 else curr + 1
        (math.max(max, updatedCurr), updatedCurr)
    }._1
    (count + 1) / 2
  }
}
