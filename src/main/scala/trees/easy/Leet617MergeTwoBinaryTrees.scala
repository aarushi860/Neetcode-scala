package trees.easy

import trees.TreeNode

object Leet617MergeTwoBinaryTrees {
  def mergeTrees(root1: TreeNode, root2: TreeNode): TreeNode = {
    (root1, root2) match {
      case (null, null) => null
      case (r1, null) => r1
      case (null, r2) => r2
      case (r1, r2) =>
        val node = new TreeNode(r1.value + r2.value)
        node.left = mergeTrees(r1.left, r2.left)
        node.right = mergeTrees(r1.right, r2.right)
        node
    }
  }
}
