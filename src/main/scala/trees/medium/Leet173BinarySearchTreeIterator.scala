package trees.medium

import trees.TreeNode

import scala.collection.mutable

object Leet173BinarySearchTreeIterator {
  class BSTIterator(_root: TreeNode) {

    private val preOrderList: mutable.ListBuffer[Int] = mutable.ListBuffer.empty
    private var currentPointer = 0
    preOrderTraversal(_root)

    def next(): Int = {
      val result = preOrderList(currentPointer)
      currentPointer += 1
      result
    }

    def hasNext(): Boolean = {
      preOrderList.nonEmpty && currentPointer < preOrderList.size
    }

    private def preOrderTraversal(_root: TreeNode): Unit = {
      if (_root != null) {
        preOrderTraversal(_root.left)
        preOrderList.addOne(_root.value)
        preOrderTraversal(_root.right)
      }
    }
  }

}
