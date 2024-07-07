package twoPointers.easy

object Leet125ValidPalindrome {
  def isPalindrome(s: String): Boolean = {
    val preProcess = s.filter(x => x.isDigit || x.isLetter).toLowerCase
    isValidPalindrome(0, preProcess.length - 1, preProcess)

  }

  private def isValidPalindrome(left: Int, right: Int, s: String): Boolean = {
    if (left == right)
      true
    else {
      if (s.charAt(left) != s.charAt(right))
        false
      else isValidPalindrome(left + 1, right - 1, s)
    }
  }

}
