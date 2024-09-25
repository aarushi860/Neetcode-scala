package dynamicProgramming.Two2D.medium

object Leet1143LongestCommonSubsequence {
  def longestCommonSubsequence(text1: String, text2: String): Int = {
    longestCommonSubsequenceWithDP(0, 0, text1, text2, Array.fill(text1.length, text2.length)(-1))
  }

  private def longestCommonSubsequenceWithDP(i: Int, j: Int, text1: String, text2: String, memo: Array[Array[Int]]): Int = {
    if (i == text1.length || j == text2.length) 0
    else if (memo(i)(j) != -1) memo(i)(j)
    else {
      val result = if (text1.charAt(i) == text2.charAt(j)) {
        1 + longestCommonSubsequenceWithDP(i + 1, j + 1, text1, text2, memo)
      } else {
        Math.max(longestCommonSubsequenceWithDP(i + 1, j, text1, text2, memo), longestCommonSubsequenceWithDP(i, j + 1, text1, text2, memo))
      }
      memo(i)(j) = result
      result
    }
  }
}
