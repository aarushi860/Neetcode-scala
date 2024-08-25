package trees.medium

import trees.TreeNode

//not working
object Leet662MaximumWidthofBinaryTree {
  def widthOfBinaryTree(root: TreeNode): Int = {
    getMax(Option(root).toList, 1)
  }

  private def getMax(nodes: List[TreeNode], max: Int): Int = {
    if (nodes.isEmpty || nodes.forall(_ == null)) max
    else {
      val updatedNodes = nodes.flatMap(node => if (node == null) List(null, null) else List(node.left, node.right))
      //      val updatedMax = if (updatedNodes.forall(_ == null)) max
      //      else Math.max(max, getCurrentMax(updatedNodes))
      getMax(updatedNodes, Math.max(max, getCurrentMax(updatedNodes)))
    }
  }

  private def getCurrentMax(updatedNodes: List[TreeNode]) = {
    val lastIdx = updatedNodes.lastIndexWhere(_ != null)
    val firstIdx = updatedNodes.indexWhere(_ != null)
    if (lastIdx == -1) -1 else lastIdx - firstIdx + 1
  }
}
