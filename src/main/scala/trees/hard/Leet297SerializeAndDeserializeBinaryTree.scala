package trees.hard

import trees.TreeNode

import scala.collection.mutable

object Leet297SerializeAndDeserializeBinaryTree {
  class Codec {
    // Encodes a list of strings to a single string.
    def serialize(root: TreeNode): String = {
      serializeToString(root,"")
    }

    private def serializeToString(root:TreeNode,str:String):String={
      if(root==null)str + "null"
      else{
        val rootStr=s"$str${root.value}"
        val leftStr=serializeToString(root.left,"")
        val rightStr=serializeToString(root.right,"")
        s"$rootStr,$leftStr,$rightStr"
      }
    }

    // Decodes a single string to a list of strings.
    def deserialize(data: String): TreeNode = {
      val splits=data.split(',')
      val queue=mutable.Queue[String]()
      queue.addAll(splits)
      deserializeToNode(queue)
    }

    private def deserializeToNode(queue:mutable.Queue[String]):TreeNode={
      if(queue.nonEmpty && queue.head == "null"){
        queue.dequeue()
        null
      }else{
        val root=new TreeNode(queue.dequeue().toInt)
        root.left=deserializeToNode(queue)
        root.right=deserializeToNode(queue)
        root
      }
    }
  }
}
