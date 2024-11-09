package trees.medium

import trees.TreeNode

object Leet129SumRoottoLeafNumbers {

  def sumNumbers(root: TreeNode): Int = {
    updateSum(root, 0)
  }

  private def updateSum(root: TreeNode, numberformed: Int): Int = {
    val updatedNumber = numberformed * 10 + root.value
    (root.left, root.right) match {
      case (null, null) => updatedNumber
      case (null, rightNode) => updateSum(root.right, updatedNumber)
      case (leftNode, null) => updateSum(root.left, updatedNumber)
      case (leftnode, rightnode) => updateSum(leftnode, updatedNumber) + updateSum(rightnode, updatedNumber)
    }
  }
}
