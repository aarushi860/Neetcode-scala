package trees.medium

import trees.TreeNode

object Leet979DistributeCoinsInBinaryTree {
  var moves = 0

  def distributeCoins(root: TreeNode): Int = {
    getMoves(root)
    moves
  }

  private def getMoves(root: TreeNode): Int = {
    if (root == null) 0
    else {
      val leftMoves = getMoves(root.left)
      val rightMoves = getMoves(root.right)
      moves += Math.abs(leftMoves) + Math.abs(rightMoves)
      root.value - 1 + leftMoves + rightMoves
    }
  }
}
