package trees.medium

import trees.TreeNode

import scala.collection.mutable

object Leet337HouseRobberIII {

  val map: mutable.Map[TreeNode, Int] = mutable.Map.empty

  def rob(root: TreeNode): Int = {
    if (root == null) 0
    else if (map.contains(root)) map(root)
    else {
      val (rootselected, childrenSelected) = (root.left, root.right) match {
        case (null, null) => (root.value, 0)
        case (left, null) =>
          val rootSelected = root.value + rob(left.left) + rob(left.right)
          (rootSelected, rob(left))
        case (null, right) =>
          val rootSelected = root.value + rob(right.left) + rob(right.right)
          (rootSelected, rob(right))
        case (left, right) =>
          val rootSelected = root.value + rob(right.left) + rob(right.right) + rob(left.left) + rob(left.right)
          (rootSelected, rob(left) + rob(right))
      }
      map.put(root, Math.max(rootselected, childrenSelected))
      map(root)
    }
  }
}