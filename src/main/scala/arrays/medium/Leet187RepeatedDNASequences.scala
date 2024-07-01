package arrays.medium

object Leet187RepeatedDNASequences {
  def findRepeatedDnaSequences(s: String): List[String] = {
    if(s.length<10) Nil
    else checkRepeated(Set(), 0, s, Set()).toList
  }

  def checkRepeated(seen:Set[String], idx: Int, s: String, result: Set[String]): Set[String] = {

    if (idx == s.length - 9) result
    else {
      val str = s.substring(idx, idx + 10)
      if (seen.contains(str)) {
        val list = result.+(str)
        checkRepeated(seen, idx + 1, s, list)
      } else checkRepeated(seen.+(str), idx + 1, s, result)
    }
  }
}
