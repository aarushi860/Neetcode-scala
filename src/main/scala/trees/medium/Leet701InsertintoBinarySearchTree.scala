package trees.medium

import trees.TreeNode

object Leet701InsertintoBinarySearchTree {
  def insertIntoBST(root: TreeNode, `val`: Int): TreeNode = {
    if (root == null) new TreeNode(`val`)
    else {
      if (root.value > `val`)
        root.left = insertIntoBST(root.left, `val`)
      else root.right = insertIntoBST(root.right, `val`)
      root
    }
  }
}
