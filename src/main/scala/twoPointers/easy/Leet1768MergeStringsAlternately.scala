package twoPointers.easy

object Leet1768MergeStringsAlternately {
  def mergeAlternately(word1: String, word2: String): String = {
    merge(0, 0, word1, word2, "")
  }

  private def merge(idx1: Int, idx2: Int, word1: String, word2: String, merged: String): String = {
    if (idx1 == word1.length && idx2 == word2.length)
      merged
    else if (idx2 == word2.length)
      merged + word1.substring(idx1)
    else if (idx1 == word1.length)
      merged + word2.substring(idx2)
    else {
      merge(idx1 + 1, idx2 + 1, word1, word2, merged + word1.charAt(idx1) + word2.charAt(idx2))
    }
  }
}
