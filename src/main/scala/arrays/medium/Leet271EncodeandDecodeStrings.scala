package arrays.medium

object Leet271EncodeandDecodeStrings extends App {
  // Encodes a list of strings to a single string.
  def encode(strs: List[String]): String = {
    strs.map(str => s"${str.length}#$str")
      .mkString
  }

  // Decodes a single string to a list of strings.
  def decode(s: String): List[String] = {
    get(List(), 0, s)
  }

  def get(acc: List[String], idx: Int, s: String): List[String] = {
    if (idx >= s.length)
      acc
    else {
      val splitIndx = s.indexOf("#", idx)
      val length = s.substring(idx, splitIndx).toInt
      val str = s.substring(splitIndx + 1, splitIndx + length + 1)
      get(acc :+ str, splitIndx + length + 1, s)
    }
  }
}
