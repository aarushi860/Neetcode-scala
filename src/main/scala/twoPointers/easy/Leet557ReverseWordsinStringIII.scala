package twoPointers.easy

object Leet557ReverseWordsinStringIII {
  def reverseWords(s: String): String = {
    s.split(' ').map(word => reverse(0, word.length - 1, word.toCharArray)).mkString(" ")
  }

  private def reverse(left: Int, right: Int, word: Array[Char]): String = {
    if (left >= right)
      word.mkString
    else {
      val temp = word(left)
      word(left) = word(right)
      word(right) = temp
      reverse(left + 1, right - 1, word)
    }
  }
}
