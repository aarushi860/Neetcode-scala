package trees.easy

import trees.TreeNode

object Leet783MinimumDistanceBetweenBSTNodes {
  def minDiffInBST(root: TreeNode): Int = {
    val list=inorderTraversal(root)
    list.sliding(2).map(x=> Math.abs(x.last-x.head)).min
  }
  private def inorderTraversal(root:TreeNode):List[Int]={
    if(root==null) List()
    else{
      inorderTraversal(root.left)++List(root.value)++inorderTraversal(root.right)
    }
  }

}
