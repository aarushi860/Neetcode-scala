package linkedList.medium

import linkedList.ListNode

//1,4,3,2,5,2
//1,2,2,4,3,5

//4,5,6,7,8,1
object Leet86PartitionList {
  def partition(head: ListNode, x: Int): ListNode = {
    // println(lastHead.x)
    if (head == null) head
    else {
      val lastHead = getLastHead(head)
      if (head == lastHead) head
      else {
        val prev = new ListNode(-1)
        prev.next = head
        partitionNodes(prev, x, lastHead, lastHead)
        prev.next
      }
    }
  }

  private def partitionNodes(firstHead: ListNode, x: Int, lastElement: ListNode, lastHead: ListNode): Unit = {
    if (firstHead.next == lastElement) {
      if (firstHead.next.x >= x && lastElement != lastHead) moveNodes(firstHead, lastHead)
    }
    else {
      if (firstHead.next.x < x) partitionNodes(firstHead.next, x, lastElement, lastHead)
      else {
        val nodeToMove = moveNodes(firstHead, lastHead)
        partitionNodes(firstHead, x, lastElement, nodeToMove)
      }
    }
  }

  private def moveNodes(firstHead: ListNode, lastHead: ListNode) = {
    val nodeToMove = firstHead.next
    firstHead.next = firstHead.next.next
    lastHead.next = nodeToMove
    nodeToMove.next = null
    nodeToMove
  }

  private def getLastHead(head: ListNode): ListNode = {
    if (head.next == null) head
    else getLastHead(head.next)
  }


}
