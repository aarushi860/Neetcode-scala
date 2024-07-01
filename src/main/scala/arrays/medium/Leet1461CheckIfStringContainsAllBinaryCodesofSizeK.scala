package arrays.medium

object Leet1461CheckIfStringContainsAllBinaryCodesofSizeK {

  def hasAllCodes(s: String, k: Int): Boolean = {
    val total = Math.pow(2, k)
    checkBinaryCode(k, k, s, total, Set())
  }

  private def checkBinaryCode(k: Int, idx: Int, s: String, total: Double, set: Set[String]): Boolean = {
    if (idx > s.length)
      total == 0
    else {
      val str = s.substring(idx - k, idx)
      if (set.contains(str)) {
        checkBinaryCode(k, idx + 1, s, total, set)
      } else checkBinaryCode(k, idx + 1, s, total - 1, set.+(str))
    }
  }
}
