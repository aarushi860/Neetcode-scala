package trees.easy

import trees.TreeNode

object Leet112PathSum {
  def hasPathSum(root: TreeNode, targetSum: Int): Boolean = {
    if(root==null)false
    else if(root.left==null && root.right==null && root.value==targetSum)true
    else hasPathSum(root.left,targetSum-root.value) || hasPathSum(root.right,targetSum-root.value)
  }
}
