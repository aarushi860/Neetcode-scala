package arrays.easy

object Leet1624LargestSubstringBetweenTwoEqualCharacters {

  def maxLengthBetweenEqualCharacters(s: String): Int = {
    s.foldLeft((Map.empty[Char, Int], -1, 0)) {
      case ((map, max, idx), char) =>
        if (map.contains(char)) {
          val length = idx - map(char)-1
          (map, math.max(max, length), idx + 1)
        } else (map.updated(char, idx), max, idx + 1)
    }._2
  }
}
