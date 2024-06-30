package arrays.easy

object Leet242ValidAnagram extends App {

  println(isAnagram("anagram", "nagaram"))

  def isAnagram(s: String, t: String): Boolean = {
    if (s.length != t.length)
      false
    else {
      val sMap = s.groupMapReduce(x => x)(_ => 1)(_ + _)
      val tMap = t.groupMapReduce(x => x)(_ => 1)(_ + _)
      sMap == tMap
    }
  }
}
