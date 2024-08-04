package stack.medium

import scala.collection.mutable

object Leet394DecodeString {
  def decodeString(s: String): String = {
    val stack = new mutable.Stack[String]()
    s.foreach { ch =>
      if (ch == ']')
        stack.push(buildDecodedString(stack))
      else stack.push("" + ch)
    }
    stack.mkString.reverse
  }

  private def buildDecodedString(stack: mutable.Stack[String]): String = {
    val decodedString = buildString("", stack)
    val k = buildNumber(0, 1, stack)
    k * decodedString
  }

  private def buildString(decodedString: String, stack: mutable.Stack[String]): String = {
    if (stack.top != "[")
      buildString(decodedString + stack.pop(), stack)
    else {
      stack.pop()
      decodedString
    }
  }

  private def buildNumber(k: Int, multiplier: Int, stack: mutable.Stack[String]): Int = {
    if (stack.nonEmpty && stack.top.length == 1 && stack.top.head.isDigit) {
      buildNumber(stack.pop().head.toInt * multiplier + k, multiplier * 10, stack)
    } else k
  }
}
