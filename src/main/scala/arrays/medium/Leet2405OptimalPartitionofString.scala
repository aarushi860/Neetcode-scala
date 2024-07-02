package arrays.medium

object Leet2405OptimalPartitionofString {

  def partitionString(s: String): Int = {
    countPartitions(1, Set(), 0, s)
  }

  def countPartitions(count: Int, set: Set[Char], idx: Int, s: String): Int = {
    if (idx == s.length) {
      count
    } else {
      val ch = s.charAt(idx)
      if (set.contains(ch)) {
        countPartitions(count + 1, Set(ch), idx + 1, s)
      } else countPartitions(count, set.+(ch), idx + 1, s)
    }
  }
}
