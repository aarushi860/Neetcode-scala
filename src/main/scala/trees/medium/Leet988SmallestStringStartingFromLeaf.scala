package trees.medium

import trees.TreeNode

object Leet988SmallestStringStartingFromLeaf {
  def smallestFromLeaf(root: TreeNode): String = {
    if (root == null) ""
    else {
      val allString = getAllString(root, "")
      allString.min
    }
  }

  private def getAllString(root: TreeNode, acc: String): List[String] = {
    val updatedString = (root.value + 'a').toChar +: acc
    (root.left, root.right) match {
      case (null, null) => List(updatedString)
      case (_, null) => getAllString(root.left, updatedString)
      case (null, _) => getAllString(root.right, updatedString)
      case (_, _) => getAllString(root.left, updatedString) ++ getAllString(root.right, updatedString)
    }
  }
}
