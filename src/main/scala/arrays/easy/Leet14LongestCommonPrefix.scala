package arrays.easy

object Leet14LongestCommonPrefix extends App {

  //  println(longestCommonPrefix(Array("flower","flow","flight")))
  println(longestCommonPrefix(Array("dog", "racecar", "car")))

  def longestCommonPrefix(strs: Array[String]): String = {
    val min = strs.minBy(_.length).length
    if (min == 0) ""
    else {
      strs.map(_.take(min)).fold(strs(0).take(min)) { (s1, s2) =>
        getCommonStart(s1, s2)
      }
    }
  }

  def getCommonStart(s1: String, s2: String) = {
    if (s1 == "" || s2 == "") ""
    else {
      val idx = getCommonLengthIdx(s1, s2)
      s1.substring(0, idx)
    }
  }

  private def getCommonLengthIdx(s1: String, s2: String) = {
    Iterator.unfold((0, false)) {
      case (_, true) => None
      case (idx, false) if idx < s1.length =>
        if (s1.charAt(idx) == s2.charAt(idx))
          Some(idx + 1, (idx + 1, false))
        else Some(idx, (idx + 1, true))
      case (_, _) => None
    }.reduce((_, b) => b)
  }

}
