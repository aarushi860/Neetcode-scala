package arrays.easy

object Leet205IsomorphicStrings extends App {
  def isIsomorphic(s: String, t: String): Boolean = {
    compareStrings(0, s, t, Map.empty, Set.empty)
  }

  private def compareStrings(index: Int, s: String, t: String, map: Map[Char, Char], usedT: Set[Char]): Boolean = {
    if (index < s.length) {
      val sChar = s.charAt(index)
      val tChar = t.charAt(index)
      if (map.contains(sChar)) {
        if (map(sChar) == tChar)
          compareStrings(index + 1, s, t, map, usedT)
        else false
      } else if (usedT.contains(tChar)) false
      else compareStrings(index + 1, s, t, map.updated(sChar, tChar), usedT.+(tChar))
    } else true
  }

}
