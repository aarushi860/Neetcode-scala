package trees.medium

import trees.TreeNode

import scala.collection.mutable

object Leet1609EvenOddTree {
  def isEvenOddTree(root: TreeNode): Boolean = {
    val queue = mutable.Queue[Node]()
    queue.addOne(Node(root, 0))
    var isValid = true
    while (queue.nonEmpty && isValid) {
      val size = queue.size
      val level = queue.head.level
      val values: List[Int] = (1 to size).map { _ =>
        val node = queue.dequeue()
        if (node.root.left != null)
          queue.addOne(Node(node.root.left, node.level + 1))
        if (node.root.right != null)
          queue.addOne(Node(node.root.right, node.level + 1))
        node.root.value
      }.toList
      isValid = if (level % 2 == 0) isIncreasing(values) else isDecreasing(values)
    }
    isValid
  }

  private def isIncreasing(nodes: List[Int]): Boolean = {
    nodes.last%2 ==1 && !nodes.indices.init.exists(idx => nodes(idx) >= nodes(idx + 1) || nodes(idx)%2==1)
  }

  private def isDecreasing(nodes: List[Int]): Boolean = {
    nodes.last%2 ==0 && !nodes.indices.init.exists(idx => nodes(idx) <= nodes(idx + 1) || nodes(idx)%2==0)
  }

  case class Node(root: TreeNode, level: Int)
}
