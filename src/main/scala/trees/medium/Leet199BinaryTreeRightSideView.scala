package trees.medium

import trees.TreeNode

object Leet199BinaryTreeRightSideView {
  def rightSideView(root: TreeNode): List[Int] = {
    if (root != null) getElements(Option(root).toList, List(root.value))
    else List()
  }

  private def getElements(nodes: List[TreeNode], acc: List[Int]): List[Int] = {
    if (nodes.isEmpty) acc
    else {
      val updatedNodes = nodes.flatMap(node => List(node.left, node.right)).filterNot(_ == null)
      val updatedAcc = acc ++ updatedNodes.lastOption.map(_.value).toList
      getElements(updatedNodes, updatedAcc)
    }
  }
}
