package arrays.easy

object Leet58LengthofLastWord extends App {

  val s = "   fly me   to   the moon  "
  println(lengthOfLastWord(s))

  def lengthOfLastWord(s: String): Int = {
    val updated: Range = (s.size - 1 to 0 by -1).dropWhile(i => s.charAt(i).isSpaceChar)
    println(updated)
    updated.takeWhile(idx => !s.charAt(idx).isSpaceChar).length
  }

}
