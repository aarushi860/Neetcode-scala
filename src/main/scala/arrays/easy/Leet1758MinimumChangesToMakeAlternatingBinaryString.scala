package arrays.easy

object Leet1758MinimumChangesToMakeAlternatingBinaryString {

  def minOperations(s: String): Int = {
    val result = s.foldLeft((0, 0, 0)) {
      case ((start0, start1, idx), char) if (idx % 2 == 0) =>
        if (char == '0') (start0 + 1, start1, idx + 1)
        else (start0, start1 + 1, idx + 1)
      case ((start0, start1, idx), char) if (idx % 2 != 0) =>
        if (char == '0') (start0, start1 + 1, idx + 1)
        else (start0 + 1, start1, idx + 1)
    }
    math.max(result._1, result._2)
  }
}
