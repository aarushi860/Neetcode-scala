package trees.medium

import trees.TreeNode

object Leet1325DeleteLeavesWithGivenValue {

  def removeLeafNodes(root: TreeNode, target: Int): TreeNode = {
    if (root == null) root
    else {
      root.left = removeLeafNodes(root.left, target)
      root.right = removeLeafNodes(root.right, target)
      if (root.left == null && root.right == null && root.value == target) null else root
    }
  }
}
