package arrays.medium

object Leet1249MinimumRemovetoMakeValidParentheses {
  def minRemoveToMakeValid(s: String): String = {
    val badSet = findBadset(0, List(), List(), s)
    s.zipWithIndex.filterNot(x => badSet.contains(x._2)).map(_._1).mkString
  }

  private def findBadset(idx: Int, closed: List[Int], opened: List[Int], s: String): Set[Int] = {
    if (idx == s.length)
      (closed ++ opened).toSet
    else {
      val ch = s.charAt(idx)
      ch match {
        case '(' => findBadset(idx + 1, closed, idx :: opened, s)
        case ')' if (opened.isEmpty) => findBadset(idx + 1, idx :: closed, opened, s)
        case ')' => findBadset(idx + 1, closed, opened.tail, s)
        case _ => findBadset(idx + 1, closed, opened, s)
      }
    }
  }
}
