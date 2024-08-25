package trees.medium

import trees.TreeNode

object Leet958CheckCompletenessofBinaryTree {
  def isCompleteTree(root: TreeNode): Boolean = {
   verify(Option(root).toList, (true,List(List(root.value.toString))))._1
  }

  private def verify(nodes: List[TreeNode], acc: (Boolean,List[List[String]])): (Boolean,List[List[String]]) = {
    if (nodes.isEmpty|| !acc._1) acc
    else {
      val updatedNodes = nodes.flatMap(node => List(node.left, node.right))
      val str = updatedNodes.map(node => if (node == null) "#" else node.value.toString)
      val idx=acc._2.last.indexWhere(_=="#")
      val isValid=idx == -1 || (idx until acc._2.last.length).forall(i=> acc._2.last(i)=="#")
      val updatedAcc= acc._2:+str
      verify(updatedNodes.filterNot(_ == null), (isValid, updatedAcc))
    }
  }
}
