package dynamicProgramming.One1D.medium

object Leet647PalindromicSubstrings {
  def countSubstrings(s: String): Int = {
    val n = s.length
    val dp = Array.ofDim[Boolean](n, n)
    dp.indices.foreach(idx => dp(idx)(idx) = true)

    dp.indices.init.foreach { idx =>
      if (s.charAt(idx) == s.charAt(idx + 1))
        dp(idx)(idx + 1) = true
    }

    (2 until n).foreach { length =>
      (0 until n-length).foreach { i =>
        val j = i + length
        if (s.charAt(i) == s.charAt(j) && dp(i + 1)(j - 1))
          dp(i)(j) = true
      }
    }
    dp.indices.map(idx => dp(idx).count(_ == true)).sum
  }
}
