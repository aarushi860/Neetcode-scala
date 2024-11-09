package trees.medium

import scala.collection.mutable

object Leet1361ValidateBinaryTreeNodes {
  def validateBinaryTreeNodes(n: Int, leftChild: Array[Int], rightChild: Array[Int]): Boolean = {
    val root=findRootNode(leftChild,rightChild, n)
    if(root== -1)false
    else{
      val seen=Array.fill(n)(false)
      val stack= new mutable.Stack[Int]()
      stack.addOne(root)
      var valid=true
      while(stack.nonEmpty && valid){
        val node=stack.pop()
        val children=List(leftChild(node),rightChild(node)).filterNot(_ == -1)
        children.foreach{child=>
          if(seen(child))valid=true
          stack.push(child)
          seen(child)=true
        }
      }
      if(valid) seen.count(_ == true) == n else false
    }
  }

  private def findRootNode(leftChild:Array[Int],rightChild:Array[Int],n:Int)={
    val allChildren=(leftChild.filterNot(_== -1)++rightChild.filterNot(_ == -1)).toSet
    val roots=(0 until n) .filterNot {i=>allChildren.contains(i)}
    if(roots.size != 1)-1 else roots.head
  }
}
