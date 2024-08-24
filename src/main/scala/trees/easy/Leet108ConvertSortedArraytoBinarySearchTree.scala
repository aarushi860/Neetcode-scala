package trees.easy

import trees.TreeNode

object Leet108ConvertSortedArraytoBinarySearchTree {
  def sortedArrayToBST(nums: Array[Int]): TreeNode = {
    constructTree(0,nums.length-1,nums)
  }

  private def constructTree(left:Int,right:Int,nums:Array[Int]):TreeNode={
    if(left>right)null
    else {
      val mid= (left+right)/2
      val node=new TreeNode(nums(mid))
      node.left=constructTree(left,mid-1,nums)
      node.right=constructTree(mid+1,right, nums)
      node
    }
  }
}
