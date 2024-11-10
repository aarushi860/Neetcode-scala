package trees.medium

import trees.TreeNode

object Leet538ConvertBSTToGreaterTree {
  def convertBST(root: TreeNode): TreeNode = {
    def calculate(root: TreeNode, sum: Int): (TreeNode, Int) = {
      if (root == null) (null, sum)
      else {
        val (right, rightSum) = calculate(root.right, sum)
        val updatedSum = root.value + rightSum
        root.value += rightSum
        val (left, leftSum) = calculate(root.left, updatedSum)
        root.left = left
        root.right = right
        (root, leftSum)
      }
    }
    calculate(root, 0)._1
  }
}
