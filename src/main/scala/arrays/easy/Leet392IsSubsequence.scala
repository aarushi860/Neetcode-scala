package arrays

object Leet392IsSubsequence extends App{

  println(isSubsequence("abc","ahbgdc"))
  println(isSubsequence("axc","ahbgdc"))
  def isSubsequence(s: String, t: String): Boolean = {
    if (s.isBlank())
      true
    else {
      Iterator.unfold(State_(0, -1, finished = false)) {
        case State_(_, _, true) => None
        case State_(index, lastIndex, _) if index < s.length =>
          println("index is " + index + "last index is " + lastIndex)
          val ch = s.charAt(index)
          val position = t.indexOf(ch, lastIndex + 1)
          if (position == - 1 || position < lastIndex)
            Some(false, State_(index + 1, -1, finished = true))
          else Some(true, State_(index + 1, position, finished = false))
        case State_(_, _, _) => None
      }.reduce(_ && _)
    }
  }
}

case class State_(currindex:Int,lastIndex:Int,finished:Boolean)
