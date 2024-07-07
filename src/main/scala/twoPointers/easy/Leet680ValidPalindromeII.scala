package twoPointers.easy

object Leet680ValidPalindromeII {
  def validPalindrome(s: String): Boolean = {
    checkPalindrome(0, s.length - 1, s)
  }

  private def checkPalindrome(left: Int, right: Int, s: String): Boolean = {
    if (left >= right)
      true
    else {
      if (s.charAt(left) != s.charAt(right))
        isValidPalindrome(left + 1, right, s) || isValidPalindrome(left, right - 1, s)
      else checkPalindrome(left + 1, right - 1, s)
    }
  }

  private def isValidPalindrome(left: Int, right: Int, s: String): Boolean = {
    if (left >= right)
      true
    else {
      if (s.charAt(left) != s.charAt(right)) {
        false
      } else isValidPalindrome(left + 1, right - 1, s)
    }
  }


}
