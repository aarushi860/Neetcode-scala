package trees.easy

import trees.TreeNode

object Leet101SymmetricTree {
  def isSymmetric(root: TreeNode): Boolean = {
    if(root==null)true
    else areSubtreesEqual(root.left,root.right)
  }

  private def areSubtreesEqual(left:TreeNode,right:TreeNode):Boolean={
    if(left==null && right==null)true
    else if(left==null || right==null || left.value!=right.value)false
    else{
      areSubtreesEqual(left.left,right.right) && areSubtreesEqual(left.right,right.left)
    }
  }
}
