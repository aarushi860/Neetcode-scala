package trees.medium

import trees.TreeNode

import scala.collection.mutable

object Leet515FindLargestValueinEachTreeRow {
  def largestValues(root: TreeNode): List[Int] = {
    val queue= new mutable.Queue[TreeNode]
    queue.addOne(root)
    val result= mutable.ListBuffer[Int]()
    while(queue.nonEmpty){
      val size=queue.size
      val minimum=(1 to size).map{_=>
        val element=queue.dequeue()
        if(element.left!=null)
          queue.addOne(element.left)
        if(element.right!= null)
          queue.addOne(element.right)
        element.value
      }.max
      result.addOne(minimum)
    }
    result.toList
  }
}
