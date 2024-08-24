package linkedList.medium

import linkedList.Node

import scala.collection.mutable

object Leet138CopyListwithRandomPointer {

  val map: mutable.Map[Node, Node] = mutable.Map.empty

  def copyRandomList(head: Node): Node = {
    copy(head)
  }
  private def copy(head: Node): Node = {
    if (head == null) null
    else {
      if (map.contains(head)) map(head)
      else {
        val node = new Node(head.value)
        map.put(head, node)
        node.next = copy(head.next)
        node.random = copy(head.random)
        node
      }
    }
  }


}
