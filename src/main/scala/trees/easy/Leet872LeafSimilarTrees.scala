package trees.easy

import trees.TreeNode

object Leet872LeafSimilarTrees {
  def leafSimilar(root1: TreeNode, root2: TreeNode): Boolean = {
    getLeavesSequence(root1) == getLeavesSequence(root2)
  }

  private def getLeavesSequence(root: TreeNode): List[Int] = {
    if (root == null) List()
    else if (root.left == null && root.right == null) List(root.value)
    else getLeavesSequence(root.left) ++ getLeavesSequence(root.right)
  }
}
