package dynamicProgramming.Two2D.medium

object Leet97InterleavingString {
  def isInterleave(s1: String, s2: String, s3: String): Boolean = {
    val dp = Array.fill(s1.length+1, s2.length+1)(-1)
    def interLeaveWithDp(i: Int, j: Int, k: Int): Boolean = {
      if (k == s3.length && j == s2.length && i == s1.length) true
      else if(k==s3.length)false
      else if (dp(i)(j) != -1) dp(i)(j) == 0
      else {
        val result = {
          val ch1 = if(s1.isDefinedAt(i))Some(s1.charAt(i))else None
          val ch2 = if(s2.isDefinedAt(j))Some(s2.charAt(j)) else None
          val ch3 = s3.charAt(k)
          if (ch1.isDefined && ch1.get == ch3 && ch2.isDefined && ch2.get == ch3)
            interLeaveWithDp(i + 1, j, k + 1) || interLeaveWithDp(i, j + 1, k + 1)
          else if (ch1.isDefined && ch1.get == ch3) interLeaveWithDp(i + 1, j, k + 1)
          else if (ch2.isDefined && ch2.get == ch3) interLeaveWithDp(i, j + 1, k + 1)
          else false
        }
        dp(i)(j) = if (result) 0 else 1
        result
      }
    }
    interLeaveWithDp(0, 0, 0)
  }
}
