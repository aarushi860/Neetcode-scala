package arrays.easy

object Leet290WordPattern extends App {
  def wordPattern(pattern: String, s: String): Boolean = {
    checkValid(0, Map.empty, pattern, s.split(' '), Set.empty)
  }

  def checkValid(idx: Int, map: Map[Char, String], pattern: String, s: Array[String], set: Set[String]): Boolean = {
    if (idx < s.length) {
      val ch = pattern.charAt(idx)
      val str = s(idx)
      if (map.contains(ch)) {
        if (str == map(ch))
          checkValid(idx + 1, map, pattern, s, set)
        else false
      } else {
        if (set.contains(str)) false
        else checkValid(idx + 1, map.updated(ch, str), pattern, s, set.+(str))
      }
    } else true
  }

}
