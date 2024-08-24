package trees.medium

import trees.TreeNode

object Leet606ConstructStringfromBinaryTree {
  def tree2str(root: TreeNode): String = {
    if (root == null) ""
    else {
      val leftChild = tree2str(root.left)
      val rightChild = tree2str(root.right)
      if (rightChild.isBlank && leftChild.isBlank)
        s"${root.value}"
      else if (rightChild.isBlank)
        s"${root.value}($leftChild)"
      else s"${root.value}($leftChild)($rightChild)"
    }
  }
}
