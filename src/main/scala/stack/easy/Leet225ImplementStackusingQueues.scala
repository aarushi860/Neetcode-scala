package stack.easy

import scala.collection.mutable

object Leet225ImplementStackusingQueues {
  class MyStack() {

    private val queue: mutable.Queue[Int] = new mutable.Queue[Int]()

    def push(x: Int): Unit = {
      queue.enqueue(x)
      var n = queue.size
      while (n > 1) {
        queue.enqueue(queue.dequeue())
        n = n - 1
      }
    }

    def pop(): Int = {
      queue.dequeue()
    }

    def top(): Int = {
      queue.head
    }

    def empty(): Boolean = {
      queue.isEmpty
    }

  }
}
