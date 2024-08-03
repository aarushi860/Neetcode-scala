package stack.medium

import scala.collection.mutable

object Leet155MinStack {
  class MinStack() {

    val stack = new mutable.Stack[Int]()
    val minStack = new mutable.Stack[Int]()

    def push(`val`: Int): Unit = {
      stack.push(`val`)
      if (minStack.nonEmpty && minStack.top < `val`) {
        minStack.push(minStack.top)
      } else minStack.push(`val`)
    }

    def pop(): Unit = {
      stack.pop()
      minStack.pop()
    }

    def top(): Int = {
      stack.top
    }

    def getMin(): Int = {
      minStack.top
    }

  }

}
