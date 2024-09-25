package dynamicProgramming.One1D.medium

object Leet91DecodeWays {

  //2326
  def numDecodings(s: String): Int = {
    countDecodings(0, s, Array.fill(s.length)(-1))
  }

  private def countDecodings(idx: Int, s: String, memo: Array[Int]): Int = {
    if (idx == s.length) 1
    else if (s.charAt(idx) == '0') 0
    else if (idx == s.length - 1) 1
    else if (memo(idx) != -1) memo(idx)
    else {
      val oneCharCount = countDecodings(idx + 1, s, memo)
      val twoCharCount = if (Integer.parseInt(s.substring(idx, idx + 2)) <= 26) countDecodings(idx + 2, s, memo) else 0
      memo(idx) = oneCharCount + twoCharCount
      //   println(s"at idx $idx , memo is ${memo(idx)} , one char $oneCharCount , two char $twoCharCount")
      memo(idx)
    }
  }
}
