package arrays.easy

object Leet2264Largest3SameDigitNumberInString {
  def largestGoodInteger(num: String): String = {
    val n = num.length
    val max = num.foldLeft((-1, 0)) {
      case ((max, idx), _) if (idx <= n - 3) =>
        val maxUpdate = Math.max(max, getNumber(idx, num))
        (maxUpdate, idx + 1)
      case (result, _) => result
    }._1
    if (max == -1) "" else s"$max$max$max"
  }

  private def getNumber(idx: Int, s: String) = {

    val char = s.charAt(idx)
    val result = s.substring(idx, idx + 3).forall(_ == char)
    if (result) char - '0' else -1
  }


}
