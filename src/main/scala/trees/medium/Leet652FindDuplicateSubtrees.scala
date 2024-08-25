package trees.medium

import trees.TreeNode

object Leet652FindDuplicateSubtrees {
  def findDuplicateSubtrees(root: TreeNode): List[TreeNode] = {

    def nStr(root: TreeNode): Seq[(TreeNode, String)] = {
      if (root == null) Seq()
      else {
        val leftStr = nStr(root.left)
        val rightStr = nStr(root.right)
        val left = leftStr.map(_._2).headOption.getOrElse("_")
        val right = rightStr.map(_._2).headOption.getOrElse("_")
        val str = s"($left.${root.value}.$right)"
        println(s"For root ${root.value}, str is ${str}")
        Seq(Seq((root, str)) ++ leftStr ++ rightStr).flatten
      }
    }

    nStr(root).groupBy(_._2).filter(_._2.length > 1).map(_._2.head._1).toList
  }


}
