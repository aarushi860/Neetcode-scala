package stack.medium

import scala.collection.mutable

object Leet1209RemoveAllAdjacentDuplicatesinStringII {
  //  "deeedbbcccbdaa", k = 3
  def removeDuplicates(s: String, k: Int): String = {
    val stack = new mutable.Stack[Value]()
    s.foreach { ch =>
      if (stack.nonEmpty && stack.top.num == ch) {
        if (stack.top.count == k - 1)
          removeKChars(k - 1, stack)
        else stack.push(Value(ch, stack.top.count + 1))
      } else stack.push(Value(ch, 1))
    }
    stack.map(_.num).mkString.reverse

  }

  private def removeKChars(k: Int, stack: mutable.Stack[Value]): Unit = {
    if (k > 0) {
      stack.pop()
      removeKChars(k - 1, stack)
    }
  }

  case class Value(num: Char, count: Int)
}
