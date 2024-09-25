package dynamicProgramming.One1D.medium

object Leet5LongestPalindromicSubstring {
  def longestPalindrome(s: String): String = {
    val n = s.length
    val dp = Array.ofDim[Boolean](n, n)
    dp.indices.foreach(idx => dp(idx)(idx) = true)
    dp.indices.init.foreach { idx =>
      if (s.charAt(idx) == s.charAt(idx + 1)) dp(idx)(idx + 1) = true
    }
    (2 until n).foreach { diff =>
      (0 until n - diff).foreach { i =>
        if (s.charAt(i) == s.charAt(i + diff) && dp(i + 1)(i + diff - 1))
          dp(i)(i + diff) = true
      }
    }

    dp.indices.flatMap { i =>
      val maxIdx = dp(i).indices.filter(j => dp(i)(j)).maxOption
      maxIdx.map(x => s.substring(i, x + 1))
    }.maxBy(_.length)

  }
}
