package trees.medium

import trees.TreeNode

object Leet98ValidateBinarySearchTree {
  def isValidBST(root: TreeNode): Boolean = {
    verify(root, None, None)
  }

  private def verify(root: TreeNode, min: Option[Int], max: Option[Int]): Boolean = {
    if (root == null) true
    else {
      if ((max.isEmpty || (max.isDefined && root.value < max.get)) && (min.isEmpty || (min.isDefined && root.value > min.get))) {
        verify(root.left, min, Some(root.value)) && verify(root.right, Some(root.value), max)
      } else false
    }
  }
}
