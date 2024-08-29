package trees.medium

import trees.TreeNode

object Leet129SumRoottoLeafNumbers {
  def sumNumbers(root: TreeNode): Int = {
    sum(root)._1
  }

  private def sum(root:TreeNode):(Int,Int)={
    if(root==null)(0,0)
    else{
      val (leftSum,leftPow)=sum(root.left)
      val (rightSum,rightPow)=sum(root.right)
      val ans=leftSum+Math.pow(root.value,leftPow+1) +rightSum+Math.pow(root.value,rightPow+1)
      (ans.toInt,Math.max(rightPow,leftPow)+1)
    }
  }
}
