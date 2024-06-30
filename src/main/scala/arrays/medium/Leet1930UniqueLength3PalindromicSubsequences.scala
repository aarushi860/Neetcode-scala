package arrays.medium

object Leet1930UniqueLength3PalindromicSubsequences {
  def countPalindromicSubsequence(s: String): Int = {
    val map = s.zipWithIndex.groupMap(x => x._1)(y => y._2)
    map.foldLeft(0) {
      case (count, (_, idxs)) =>
        val start = idxs.head
        val end = idxs.last
        val innerChars = (start + 1 until end).map(s.charAt)
        count + innerChars.toSet.size
    }
  }
}
