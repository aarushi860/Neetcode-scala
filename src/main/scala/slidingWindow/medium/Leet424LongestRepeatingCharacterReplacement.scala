package slidingWindow.medium

object Leet424LongestRepeatingCharacterReplacement {
  def characterReplacement(s: String, k: Int): Int = {
    val array = s.map(_ - 'A')
    val left = array.zipWithIndex.foldLeft(0, Map.empty[Int, Int], 0) {
      case ((maxFq, fMap, left), (num, idx)) =>
        val updatedMap = fMap.updated(num, fMap.getOrElse(num, 0) + 1)
        val updatedMaxFq = Math.max(updatedMap(num), maxFq)
        val isWindowValid = idx - left + 1 - updatedMaxFq <= k
        if (!isWindowValid)
          (updatedMaxFq, updatedMap.updated(array(left), updatedMap(array(left)) - 1), left + 1)
        else (updatedMaxFq, updatedMap, left)
    }._3
    array.length - left
  }
}
