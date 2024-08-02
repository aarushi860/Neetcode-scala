package stack.easy

import scala.collection.mutable

object Leet1544MakeTheStringGreat {
  def makeGood(s: String): String = {
    val stack = new mutable.Stack[Char]()
    stack.push(s.head)
    s.tail.foldLeft(stack) {
      case (stack, ch) =>
        if (stack.isEmpty) stack.push(ch)
        else {
          val top = stack.top
          if (Math.abs(top - ch) == 32) {
            stack.pop()
            stack
          } else stack.push(ch)
        }
    }
    stack.mkString.reverse
  }
}
