package trees.easy

import trees.TreeNode

object Leet572SubtreeofAnotherTree {
  def isSubtree(root: TreeNode, subRoot: TreeNode): Boolean = {
    if(checkIfSame(root, subRoot))true
    else if(root==null) false
    else isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot)
  }

  private def checkIfSame(root:TreeNode,subRoot:TreeNode):Boolean={
    if(root==null && subRoot==null)true
    else if(root==null || subRoot==null || root.value != subRoot.value)false
    else checkIfSame(root.left, subRoot.left) && checkIfSame(root.right, subRoot.right)
  }
}
