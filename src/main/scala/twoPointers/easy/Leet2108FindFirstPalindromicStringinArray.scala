package twoPointers.easy

object Leet2108FindFirstPalindromicStringinArray {

  def firstPalindrome(words: Array[String]): String = {
    words.find(word => checkPalindrome(0, word.length - 1, word)).getOrElse("")
  }

  private def checkPalindrome(left: Int, right: Int, word: String): Boolean = {
    if (left >= right)
      true
    else {
      if (word.charAt(left) != word.charAt(right))
        false
      else checkPalindrome(left + 1, right - 1, word)
    }
  }
}
