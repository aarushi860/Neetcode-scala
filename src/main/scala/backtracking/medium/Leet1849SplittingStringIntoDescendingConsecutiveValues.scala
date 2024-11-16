package backtracking.medium

object Leet1849SplittingStringIntoDescendingConsecutiveValues {
  def splitString(s: String): Boolean = {
    isValid(None, 0, s)
  }

  private def isValid(prev: Option[BigInt], idx: Int, s: String): Boolean = {
    if (idx == s.length ) true
    else {
      s.indices.filter(_ >= idx).exists { i =>
        val next = s.substring(idx, i + 1)
        (next!=s)&&(prev.isEmpty || (prev.isDefined && prev.get - BigInt(next) == 1)) &&
          isValid(Some(BigInt(next)), i + 1, s)
      }
    }
  }
}
