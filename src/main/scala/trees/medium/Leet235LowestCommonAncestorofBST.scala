package trees.medium

import trees.TreeNode

object Leet235LowestCommonAncestorofBST {
  def lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
    if(root==null || (root.value>=p.value && root.value<=q.value) || (root.value>=q.value && root.value<=p.value)) root
    else if(root.value>q.value && root.value>p.value)lowestCommonAncestor(root.right,p,q)
    else lowestCommonAncestor(root.left,p,q)
  }
}
