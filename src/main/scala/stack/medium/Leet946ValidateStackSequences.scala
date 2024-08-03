package stack.medium

import scala.collection.mutable

object Leet946ValidateStackSequences {
  def validateStackSequences(pushed: Array[Int], popped: Array[Int]): Boolean = {
    val (popIdx, stack) = pushed.zipWithIndex.foldLeft(0, new mutable.Stack[Int]()) {
      case ((popIdx, stack), (push, idx)) =>
        stack.push(push)
        updateMin(popIdx, stack, popped)
    }
    popIdx == popped.length && stack.isEmpty
  }

  def updateMin(popIdx: Int, pushed: mutable.Stack[Int], popped: Array[Int]): (Int, mutable.Stack[Int]) = {
    if (popIdx < popped.length && pushed.nonEmpty && pushed.top == popped(popIdx)) {
      pushed.pop()
      updateMin(popIdx + 1, pushed, popped)
    } else (popIdx, pushed)
  }
}
