package trees.easy

import trees.TreeNode

object Leet100SameTree {
  def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
    if(p==null && q==null)true
    else if(p==null || q==null || p.value!=q.value)false
    else isSameTree(p.left,q.left) && isSameTree(p.right,q.right)
  }
}
