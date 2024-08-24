package trees.easy

import trees.TreeNode

object Leet144BinaryTreePreorderTraversal {
  def preorderTraversal(root: TreeNode): List[Int] = {
    if(root==null)List()
    else List(root.value)++preorderTraversal(root.left)++preorderTraversal(root.right)
  }
}
