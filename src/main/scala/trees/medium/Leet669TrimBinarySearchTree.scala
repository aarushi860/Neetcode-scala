package trees.medium

import trees.TreeNode

object Leet669TrimBinarySearchTree {
  def trimBST(root: TreeNode, low: Int, high: Int): TreeNode = {
    if (root == null) root
    else if (root.value > high) trimBST(root.left, low, high)
    else if (root.value < low) trimBST(root.right, low, high)
    else {
      root.left = trimBST(root.left, low, high)
      root.right = trimBST(root.right, low, high)
      root
    }
  }

  
}
