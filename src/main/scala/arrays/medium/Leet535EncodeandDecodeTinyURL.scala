package arrays.medium

import scala.collection.mutable

object Leet535EncodeandDecodeTinyURL extends App {

  // Encodes a URL to a shortened URL.

  lazy val map: mutable.Map[String, String] = mutable.HashMap()
  val tinyPrefix = "http://tinyurl.com/"

  def encode(longURL: String): String = {
    val hash = longURL.hashCode.toString
    map.put(hash, longURL)
    s"${tinyPrefix}${hash}"
  }

  // Decodes a shortened URL to its original URL.
  def decode(shortURL: String): String = {
    val suffix = shortURL.substring(tinyPrefix.length)
    map(suffix)
  }

  val url = "https://leetcode.com/problems/design-tinyurl/"
  println(s"encode : ${decode(encode(url))}")
}
