package trees.medium

import trees.TreeNode

object Leet103BinaryTreeZigzagLevelOrderTraversal {
  def zigzagLevelOrder(root: TreeNode): List[List[Int]] = {
    if (root != null)
      orderTraversal(Option(root).toList, List(List(root.value)), flag = false)
    else List()
  }

  private def orderTraversal(nodes: List[TreeNode], acc: List[List[Int]], flag: Boolean): List[List[Int]] = {
    if (nodes.isEmpty) acc
    else {
      val updatedNodes = nodes.flatMap(node => List(node.left, node.right)).filterNot(_ == null)
      val values = updatedNodes.map(_.value)
      val list = if (flag) values else values.reverse
      val updatedAcc = if (updatedNodes.nonEmpty) acc :+ list else acc
      orderTraversal(updatedNodes, updatedAcc, !flag)
    }
  }
}
