package twoPointers.easy

object Leet1662CheckIfTwoStringArraysareEquivalent {
  def arrayStringsAreEqual(word1: Array[String], word2: Array[String]): Boolean = {
    word1.mkString == word2.mkString
  }
}
