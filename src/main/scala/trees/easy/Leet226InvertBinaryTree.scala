package trees.easy

import trees.TreeNode

object Leet226InvertBinaryTree {
  def invertTree(root: TreeNode): TreeNode = {
    if(root==null)null
    else{
      val left=root.left
      root.left=invertTree(root.right)
      root.right=invertTree(left)
      root
    }
  }
}
