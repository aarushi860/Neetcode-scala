package trees.medium

import trees.TreeNode

import scala.collection.mutable

object Leet106ConstructBinaryTreefromInorderandPostorderTraversal {
  def buildTree(inorder: Array[Int], postorder: Array[Int]): TreeNode = {
    val inorderIdxMap = inorder.zipWithIndex.toMap
    val stack = new mutable.Stack[Int]()
    postorder.foreach(x => stack.push(x))
    buildTree(inorderIdxMap, stack, 0, inorder.length - 1)
  }

  private def buildTree(inorderIdxMap: Map[Int, Int], postOrder: mutable.Stack[Int],
                        left: Int, right: Int): TreeNode = {
    if (left > right) null
    else {
      val topElement = postOrder.pop()
      val root = new TreeNode(topElement)
      val idx = inorderIdxMap(topElement)
      root.right = buildTree(inorderIdxMap, postOrder, idx + 1, right)
      root.left = buildTree(inorderIdxMap, postOrder, left, idx - 1)
      root
    }
  }

}
