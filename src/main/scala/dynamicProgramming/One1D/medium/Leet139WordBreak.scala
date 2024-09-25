package dynamicProgramming.One1D.medium

object Leet139WordBreak {
  def wordBreak(s: String, wordDict: List[String]): Boolean = {
    wordBreakWithMemo(0, Array.fill(s.length)(-1), s, wordDict)
  }

  private def wordBreakWithMemo(idx: Int, memo: Array[Int], s: String, wordDict: List[String]): Boolean = {
    if (idx >= s.length) true
    else if (memo(idx) != -1) memo(idx) == 0
    else {
      val result = wordDict.exists { word =>
        if (s.substring(idx).startsWith(word)) wordBreakWithMemo(idx + word.length, memo, s, wordDict)
        else false
      }
      if (result) memo(idx) = 0 else memo(idx) = 1
      result
    }
  }
}
