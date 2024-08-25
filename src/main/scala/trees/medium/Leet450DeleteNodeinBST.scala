package trees.medium

import trees.TreeNode

object Leet450DeleteNodeinBST {
  def deleteNode(root: TreeNode, key: Int): TreeNode = {
    if (root == null) null
    else if (root.value > key) {
      root.left = deleteNode(root.left, key)
      root
    }
    else if (root.value < key) {
      root.right = deleteNode(root.right, key)
      root
    }
    else {
      if (root.left == null && root.right == null) null
      else if (root.right != null) {
        root.value = getSuccessor(root).value
        root.right = deleteNode(root.right, root.value)
        root
      } else {
        root.value = predecessor(root).value
        root.left = deleteNode(root.left, root.value)
        root
      }
    }
  }

  private def getSuccessor(root: TreeNode) = {
    getLeftMost(root.right)
  }

  private def getLeftMost(root: TreeNode): TreeNode = {
    if (root.left == null) root
    else getLeftMost(root.left)
  }

  private def predecessor(root: TreeNode) = {
    getRightMost(root.left)
  }

  private def getRightMost(root: TreeNode): TreeNode = {
    if (root.right == null) root
    else getRightMost(root.right)
  }


}
