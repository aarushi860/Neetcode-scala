package arrays.medium

object Leet438FindAllAnagramsinString {

  def findAnagrams(s: String, p: String): List[Int] = {
    val n = p.length
    val pMap = p.groupMapReduce(x => x)(y => 1)((sum, count) => sum + count)
    s.zipWithIndex.foldLeft((List.empty[Int], Map.empty[Char, Int])) {
      case ((count, sMap), (ch, idx)) =>
        val sMapWithUpdatedChar = sMap.updated(ch, sMap.getOrElse(ch, 0) + 1)
        val sMApWithUpdate = if (idx >= n) removeCharLeavingWindow(s, idx - n, sMapWithUpdatedChar)
        else sMapWithUpdatedChar
        val updatedCount = if (sMApWithUpdate == pMap) count :+ idx - n + 1 else count
        (updatedCount, sMApWithUpdate)
    }._1
  }

  private def removeCharLeavingWindow(s: String, idx: Int, sMap: Map[Char, Int]) = {
    val ch = s.charAt(idx)
    if (sMap(ch) == 1)
      sMap.removed(ch)
    else sMap.updated(ch, sMap(ch) - 1)
  }
}
