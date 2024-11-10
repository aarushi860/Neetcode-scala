package trees.hard

import trees.TreeNode

object Leet124BinaryTreeMaximumPathSum {
  def maxPathSum(root: TreeNode): Int = {

    def maxPath(root: TreeNode): (Int, Int) = {
      if (root == null) (0, Integer.MIN_VALUE)
      else {
        val (leftsum, leftMax) = maxPath(root.left)
        val (rightSum, rightMx) = maxPath(root.right)
        val rootSum = root.value + mmax(0, leftsum, rightSum)
        val rootMax = mmax(root.value + Math.max(0, leftsum) + Math.max(0, rightSum), leftMax, rightMx)
        (rootSum, rootMax)
      }
    }

    maxPath(root)._2
  }

  def mmax(args: Int*) = args.max

}
