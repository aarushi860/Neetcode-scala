package stack.easy

import scala.collection.mutable

object Leet232ImplementQueueusingStacks {
  class MyQueue() {
    val stack1 = new mutable.Stack[Int]()
    val stack2 = new mutable.Stack[Int]()

    def push(x: Int): Unit = {
      stack1.push(x)
    }

    def pop(): Int = {
      checkAndRefillStack(stack1, stack2)
      stack2.pop()
    }

    def peek(): Int = {
      checkAndRefillStack(stack1, stack2)
      stack2.top
    }

    def empty(): Boolean = {
      stack2.isEmpty && stack1.isEmpty
    }

    private def checkAndRefillStack(stack1: mutable.Stack[Int], stack2: mutable.Stack[Int]): Unit = {
      if (stack2.isEmpty) {
        while (stack1.nonEmpty)
          stack2.push(stack1.pop())
      }
    }
  }


}
