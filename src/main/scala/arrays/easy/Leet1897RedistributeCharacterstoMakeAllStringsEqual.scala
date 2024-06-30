package arrays.easy

object Leet1897RedistributeCharacterstoMakeAllStringsEqual {
  def makeEqual(words: Array[String]): Boolean = {
    val n = words.length
    val map = words.flatMap(_.toCharArray).groupMapReduce(k => k)(_ => 1)((sum, count) => sum + count)
    map.values.forall(_ % n == 0)
  }
}
