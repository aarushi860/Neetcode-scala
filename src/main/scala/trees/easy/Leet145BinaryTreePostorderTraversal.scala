package trees.easy

import trees.TreeNode

object Leet145BinaryTreePostorderTraversal {
  def postorderTraversal(root: TreeNode): List[Int] = {
    if(root==null)List()
    else postorderTraversal(root.left)++postorderTraversal(root.right)++List(root.value)
  }
}
