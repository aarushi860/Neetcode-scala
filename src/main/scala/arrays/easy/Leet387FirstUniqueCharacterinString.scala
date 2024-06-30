package arrays.easy

object Leet387FirstUniqueCharacterinString {
  def firstUniqChar(s: String): Int = {
    val charCountMap = s.groupBy(identity).view.mapValues(_.length)
    s.indexWhere(charCountMap.get(_).contains(1))
  }
}
