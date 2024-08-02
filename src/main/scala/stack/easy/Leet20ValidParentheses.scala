package stack.easy

import scala.collection.mutable

object Leet20ValidParentheses {

  private val stack = new mutable.Stack[Char]()
  private val openCloseMap = Map('{' -> '}', '(' -> ')', '[' -> ']')
  def isValid(s: String): Boolean = {
    stack.clear()
    s.nonEmpty && s.forall(checkPar) && stack.isEmpty
  }

  private def checkPar(ch: Char) = {
    if (openCloseMap.contains(ch)) {
      stack.push(ch)
      true
    } else if (stack.nonEmpty && openCloseMap.get(stack.top).contains(ch)) {
      stack.pop()
      true
    } else false
  }
}
