package trees.easy

import trees.TreeNode

object Leet543DiameterofBinaryTree {
  def diameterOfBinaryTree(root: TreeNode): Int = {
    getHeightAndDiameter(root)._2
  }

  private def getHeightAndDiameter(root:TreeNode):(Int,Int)={
    if(root==null)(0,0)
    else{
      val (leftH,leftD)=getHeightAndDiameter(root.left)
      val(rightH,rightD)=getHeightAndDiameter(root.right)
      (1+(leftH max rightH) , leftD max rightD max (leftH+rightH))
    }
  }
}
