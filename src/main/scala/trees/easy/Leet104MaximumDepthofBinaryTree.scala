package trees.easy

import trees.TreeNode

object Leet104MaximumDepthofBinaryTree {
  def maxDepth(root: TreeNode): Int = {
    if (root == null) 0
    else Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
  }

}
