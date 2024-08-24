package trees.easy

import trees.TreeNode

object Leet94BinaryTreeInorderTraversal {
  def inorderTraversal(root: TreeNode): List[Int] = {
    if(root==null)List()
    else inorderTraversal(root.left)++List(root.value)++inorderTraversal(root.right)
  }
}
