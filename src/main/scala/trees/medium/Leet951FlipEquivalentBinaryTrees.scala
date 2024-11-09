package trees.medium

import trees.TreeNode

object Leet951FlipEquivalentBinaryTrees {
  def flipEquiv(root1: TreeNode, root2: TreeNode): Boolean = {
    (root1, root2) match {
      case (null, null) => true
      case (_, null) || (null, _) => false
      case (_, _) =>
        if (root1.value != root2.value) false
        else {
          (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
            (flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right))
        }
    }
  }
}
