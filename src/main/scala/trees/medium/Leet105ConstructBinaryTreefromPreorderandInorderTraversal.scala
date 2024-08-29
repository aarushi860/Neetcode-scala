package trees.medium

import trees.TreeNode

import scala.collection.mutable

object Leet105ConstructBinaryTreefromPreorderandInorderTraversal {
  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
    val inorderMap = inorder.zipWithIndex.toMap
    val queue = new mutable.Queue[Int]()
    preorder.foreach(x => queue.enqueue(x))
    construct(inorderMap, queue, 0, inorder.length - 1)
  }

  private def construct(inorderMap: Map[Int, Int], preOrder: mutable.Queue[Int], left: Int, right: Int): TreeNode = {
    if (left > right) null
    else {
      val top = preOrder.dequeue()
      val node = new TreeNode(top)
      val idx = inorderMap(top)
      node.left = construct(inorderMap, preOrder, left, idx - 1)
      node.right = construct(inorderMap, preOrder, idx + 1, right)
      node
    }
  }

}
