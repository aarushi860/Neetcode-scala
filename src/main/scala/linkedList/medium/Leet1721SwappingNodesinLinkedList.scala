package linkedList.medium

import linkedList.ListNode

object Leet1721SwappingNodesinLinkedList {
  def swapNodes(head: ListNode, k: Int): ListNode = {
    val prev=new ListNode(-1)
    prev.next=head
    val startKNode=nodeBeforeKFromStart(prev,k)
    val lastKNode=nodeBeforeKFromEnd(head,startKNode)
    println(s"Start node is ${startKNode.x} , last node is ${lastKNode.x}")
    val nextFirst=startKNode
    startKNode.x=lastKNode.x
    lastKNode.x=nextFirst.x
    prev.next
  }
  private def nodeBeforeKFromEnd(head:ListNode,startNode:ListNode):ListNode={
    if(startNode==null)head
    else nodeBeforeKFromEnd(head.next,startNode.next)
  }
  private def nodeBeforeKFromStart(head:ListNode,k:Int):ListNode={
    if(k==1)head
    else nodeBeforeKFromStart(head.next,k-1)
  }
}
