package trees.medium

import trees.TreeNode

import scala.collection.mutable

object Leet894AllPossibleFullBinaryTrees {

  val memo: mutable.Map[Integer, List[TreeNode]] = mutable.Map.empty
  def allPossibleFBT(n: Int): List[TreeNode] = {
    if (n % 2 == 0) Nil
    else if (n == 1) List(new TreeNode(0))
    else if (memo.contains(n)) memo(n)
    else {
      val result = (1 until n by 2).flatMap { i =>
        val leftTree = allPossibleFBT(i)
        val rightTree = allPossibleFBT(n - i - 1)
        leftTree.flatMap { eachLeftTree =>
          rightTree.map { eachRightTree =>
            new TreeNode(0, eachLeftTree, eachRightTree)
          }
        }
      }
      memo.put(n, result.toList)
      result.toList
    }
  }
}
