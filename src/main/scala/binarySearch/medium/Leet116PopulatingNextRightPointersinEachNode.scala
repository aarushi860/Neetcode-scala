package binarySearch.medium

import scala.collection.mutable

object Leet116PopulatingNextRightPointersinEachNode {
  def connect(root: Node): Node = {
    if (root == null) root
    else {
      val curr = root
      val queue = new mutable.Queue[Node]()
      queue.addOne(root)
      while (queue.nonEmpty) {
        val n = queue.size
        (0 until n).foreach { i =>
          val node = queue.dequeue()
          if (i != n - 1) node.next = queue.head
          if (node.left != null) queue.addOne(node.left)
          if (node.right != null) queue.addOne(node.right)
        }
      }
      curr
    }
  }
}


class Node(var _value: Int) {
  var value: Int = _value
  var left: Node = null
  var right: Node = null
  var next: Node = null
}
