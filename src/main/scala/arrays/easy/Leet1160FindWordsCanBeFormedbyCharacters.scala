package arrays.easy

object Leet1160FindWordsCanBeFormedbyCharacters {

  def countCharacters(words: Array[String], chars: String): Int = {
    val charMap = getWordMap(chars)
    words
      .filter(word => compare(getWordMap(word), charMap))
      .map(_.length)
      .sum
  }

  private def compare(word: Map[Char, Int], charMap: Map[Char, Int]) = {
    word
      .forall { case (key, value) => charMap.contains(key) && charMap(key) >= value }
  }

  private def getWordMap(word: String) = {
    word
      .groupMapReduce(x => x)(_ => 1)((sum, count) => sum + count)
  }
}
