package slidingWindow.medium

object Leet3LongestSubstringWithoutRepeatingCharacters {
  def lengthOfLongestSubstring(s: String): Int = {
    val (lastMax, lastStart, _) = s.indices.foldLeft(0, 0, Map[Char, Int]()) {
      case ((max, start, map), idx) =>
        val ch = s.charAt(idx)
        if (map.contains(ch) && map(ch) >= start) {
          val updatedMax = Math.max(max, idx - start)
          val newStart = map(ch) + 1
          (updatedMax, newStart, map.updated(ch, idx))
        } else (max, start, map.updated(ch, idx))

    }
    Math.max(lastMax, s.length - lastStart)
  }
}
