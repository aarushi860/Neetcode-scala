package trees.medium

import trees.TreeNode

object Leet1457PseudoPalindromicPathsinBinaryTree {
  def pseudoPalindromicPaths(root: TreeNode): Int = {
    if (root == null) 0
    else isPalindrome(root, Map.empty)
  }

  private def isPalindrome(root: TreeNode, acc: Map[Int,Int]): Int = {
    val allNumbers = acc.updated(root.value,acc.getOrElse(root.value,0)+1)
    (root.left, root.right) match {
      case (null, null) =>
        val oddCount = allNumbers.count(_._2%2==1)
        if (oddCount <= 1) 1 else 0
      case (_, null) =>
        isPalindrome(root.left,allNumbers )
      case (null, _) =>
        isPalindrome(root.right, allNumbers)
      case (_, _) =>
        isPalindrome(root.left, allNumbers) + isPalindrome(root.right,allNumbers)
    }
  }
}
