package trees.medium

import trees.TreeNode

object Leet1448CountGoodNodesinBinaryTree {
  def goodNodes(root: TreeNode): Int = {
    if (root == null) 0
    else count(root, root.value)
  }

  private def count(root: TreeNode, max: Int): Int = {
    if (root == null) 0
    else {
      val rootCount = if (root.value >= max) 1 else 0
      val leftCount = count(root.left, Math.max(max, root.value))
      val rightCount = count(root.right, Math.max(max, root.value))
      rootCount + leftCount + rightCount
    }
  }

}
