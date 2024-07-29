package slidingWindow.medium

object Leet1456MaximumNumberofVowels {

  val vowels = Set('a', 'e', 'i', 'o', 'u')

  def maxVowels(s: String, k: Int): Int = {
    val startCount = getVowelsCount(s.substring(0, k))
    s.substring(k).foldLeft(startCount, startCount, 0) {
      case ((max, curr, left), ch) =>
        val isNextVowel = vowels.contains(ch)
        val isLastVowel = vowels.contains(s.charAt(left))
        // println(s"ch ${ch} , isNextVowel ${isNextVowel} , isLastVowel ${isLastVowel} , max ${max}")
        val update1 = if (isNextVowel) curr + 1 else curr
        val update2 = if (isLastVowel) update1 - 1 else update1
        (Math.max(max, update2), update2, left + 1)
    }._1

  }

  def getVowelsCount(s: String) = {
    s.count(vowels.contains)
  }

}
