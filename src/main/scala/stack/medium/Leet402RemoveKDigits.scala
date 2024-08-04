package stack.medium

import scala.collection.mutable

object Leet402RemoveKDigits {
  def removeKdigits(num: String, k: Int): String = {
    val stack = new mutable.Stack[Int]()
    var counter = k
    num.foreach { ch =>
      val digit = ch - '0'

      while (stack.nonEmpty && stack.top > digit && counter > 0) {
        stack.pop()
        counter = counter - 1
      }
      stack.push(digit)
    }
    while (counter > 0 && stack.nonEmpty) {
      stack.pop()
      counter = counter - 1
    }
    val str = stack.mkString.reverse
    if (str.forall(_ == '0')) "0"
    else stack.mkString.reverse.dropWhile(_ == '0')
  }
}
