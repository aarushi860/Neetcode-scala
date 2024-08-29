package trees.medium

import trees.TreeNode

import scala.collection.mutable

object Leet230KthSmallestElementinaBST {
  def kthSmallest(root: TreeNode, k: Int): Int = {
    val stack = new mutable.Stack[TreeNode]()
    insertLeftBranch(root, stack)
    val top = stack.pop()
    if (k == 0) top.value
    else kthSmallest(top.right, k - 1)
  }

  private def insertLeftBranch(root: TreeNode, stack: mutable.Stack[TreeNode]): Unit = {
    if (root != null) {
      stack.push(root)
      insertLeftBranch(root.left, stack)
    }
  }


}
