package trees.easy

import trees.TreeNode

object Leet110BalancedBinaryTree {
  def isBalanced(root: TreeNode): Boolean = {
    def getBalanced(root: TreeNode): Int = {
      if (root == null) 0
      else {
        val leftHeight = getBalanced(root.left)
        val rightHeight = getBalanced(root.right)
        if (Math.abs(leftHeight - rightHeight) > 1 && leftHeight<0 && rightHeight<1) -1
        else Math.max(leftHeight, rightHeight) + 1
      }
    }
    getBalanced(root)!= -1
  }


}
