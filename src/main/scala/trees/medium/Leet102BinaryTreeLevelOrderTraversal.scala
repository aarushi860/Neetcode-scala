package trees.medium

import trees.TreeNode

import scala.collection.mutable

object Leet102BinaryTreeLevelOrderTraversal {
  def levelOrder(root: TreeNode): List[List[Int]] = {
    val q=new mutable.Queue[TreeNode]()
    if(root!=null)
    q.addOne(root)
    traverseQueue(q,List())
  }

  private def traverseQueue(queue:mutable.Queue[TreeNode],list:List[List[Int]]):List[List[Int]]={
    if(queue.isEmpty)List()
    else{
      val result=popAndAddToQueue(queue,queue.size,List())
      traverseQueue(queue,list:+result)
    }
  }

  private def popAndAddToQueue(queue:mutable.Queue[TreeNode],counter:Int,list:List[Int]):List[Int]={
    if(counter==0)list
    else {
      val node=queue.dequeue()
      val updatedList=list:+node.value
      (node.left,node.right) match{
        case (null,null) => popAndAddToQueue(queue,counter-1,updatedList)
        case (null,right) =>
          queue.addOne(right)
          popAndAddToQueue(queue,counter-1,updatedList)
        case (left,null) =>queue.addOne(left)
        popAndAddToQueue(queue, counter-1, updatedList)
        case (left,right) => queue.addOne(left)
        queue.addOne(right)
        popAndAddToQueue(queue, counter-1,updatedList)
      }
    }
  }

}
