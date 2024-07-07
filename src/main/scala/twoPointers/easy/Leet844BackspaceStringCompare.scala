package twoPointers.easy

import scala.collection.mutable

object Leet844BackspaceStringCompare {
  def backspaceCompare(s: String, t: String): Boolean = {
    constructStack(s).mkString== constructStack(t).mkString
  }

  private def constructStack(s: String) = {
    val stackS= new mutable.Stack[Char]()
    s.foreach { ch =>
      if (ch == '#') {
        if (stackS.nonEmpty)
          stackS.pop()
      } else stackS.push(ch)
    }
    stackS
  }
}
