package slidingWindow.hard

object Leet76MinimumWindowSubstring {
  def minWindow(s: String, t: String): String = {
    val tMap = t.groupBy(identity).map(x => (x._1, x._2.length))
    val required = tMap.keys.size
    s.zipWithIndex.foldLeft(0, "", Map.empty[Char, Int], 0) {
      case ((start, result, currentMap, formed), (ch, idx)) =>
        val updatedMap = currentMap.updated(ch, currentMap.getOrElse(ch, 0) + 1)
        val updatedFormed = if (tMap.contains(ch) && tMap(ch) == updatedMap(ch)) formed + 1 else formed
        if (updatedFormed == required) {
          shrinkWindow(start, idx, result, s, updatedFormed, required, updatedMap, tMap)
        } else (start, result, updatedMap, updatedFormed)
    }._2
  }

  private def shrinkWindow(l: Int, r: Int, result: String, s: String, formed: Int,
                           required: Int, currentMap: Map[Char, Int], tMap: Map[Char, Int])
  : (Int, String, Map[Char, Int], Int) = {
    if (l <= r && formed == required) {
      val updatedResult = if (result != "" || result.length > r - l + 1) s.substring(l, r + 1) else result
      val updateCurrentMap = currentMap.updated(s.charAt(l), currentMap(s.charAt(l)) - 1)
      if (tMap.contains(s.charAt(l)) && tMap(s.charAt(l)) > updateCurrentMap(s.charAt(l)))
        (l+1, updatedResult, updateCurrentMap, formed - 1)
      else shrinkWindow(l + 1, r, updatedResult, s, formed, required, updateCurrentMap, tMap)
    } else (l, result, currentMap, formed)
  }
}
