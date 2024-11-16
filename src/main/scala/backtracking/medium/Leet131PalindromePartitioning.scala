package backtracking.medium

object Leet131PalindromePartitioning {
  def partition(s: String): List[List[String]] = {
    permutations(s, s.length)
  }

  private def permutations(s: String, right: Int): List[List[String]] = {
    if (right <= 0) List.empty
    else {
      val substring = s.substring(0, right)
      if (isPalindrome(substring)) {
        val otherPart = s.substring(substring.length)
        if (otherPart == "")
          List(List(substring)) ++ permutations(s, right - 1)
        else permutations(otherPart, otherPart.length).map { list => substring +: list } ++ permutations(s, right - 1)
      } else permutations(s, right - 1)
    }
  }

  private def isPalindrome(s: String): Boolean = {
    if (s.isEmpty) true
    else if (s.head != s.last) false
    else isPalindrome(s.drop(1).dropRight(1))
  }
}
