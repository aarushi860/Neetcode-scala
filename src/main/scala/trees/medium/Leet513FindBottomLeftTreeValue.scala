package trees.medium

import trees.TreeNode

import scala.collection.mutable

object Leet513FindBottomLeftTreeValue {
  def findBottomLeftValue(root: TreeNode): Int = {
    val queue = mutable.Queue[TreeNode]()
    queue.addOne(root)
    var result = -1
    while (queue.nonEmpty) {
      val size = queue.size
      result = queue.head.value
      (1 to size).foreach { _ =>
        val node = queue.dequeue()
        if (node.left != null)
          queue.addOne(node.left)
        if (node.right != null)
          queue.addOne(node.right)
      }
    }
    result
  }
}
