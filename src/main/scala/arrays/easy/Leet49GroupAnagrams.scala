package arrays.easy

object Leet49GroupAnagrams extends App {

  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    strs.groupMap(x => hash(x))(y => y).map(_._2.toList).toList
  }

  def hash(s: String) = {
    s.foldLeft(0, 1, 1) {
      case ((lhash, mhash, rhash), char) =>
        (lhash + char - 'a', mhash * (char - 'a' + 1), rhash * ('z' - char + 1))
    } match {
      case (lhash, mhash, rhash) => s"${s.length}#$lhash#$rhash#$mhash"
    }
  }
}
