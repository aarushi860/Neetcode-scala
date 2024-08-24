package trees.easy

import trees.TreeNode

object Leet938RangeSumofBST {
  def rangeSumBST(root: TreeNode, low: Int, high: Int): Int = {
    if (root == null) 0
    else {
      if (root.value >= low && root.value <= high) {
        rangeSumBST(root.left, low, high) + root.value + rangeSumBST(root.right, low, high)
      } else if (root.value > high) rangeSumBST(root.left, low, high)
      else rangeSumBST(root.right, low, high)
    }
  }
}
