package linkedList.medium

import linkedList.ListNode

//not working
object Leet19RemoveNthNodeFromEndofList {
  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    val nthNodeFromBegin = nthNodeFromStart(n, head)
    val nthNodeFromEnd = getNthNodeFromEnd(nthNodeFromBegin, head)
    nthNodeFromEnd.next = nthNodeFromEnd.next.next
    head
  }

  private def getNthNodeFromEnd(node: ListNode, head: ListNode): ListNode = {
    if (node == null) head
    else getNthNodeFromEnd(node.next, head.next)
  }

  private def nthNodeFromStart(n: Int, head: ListNode): ListNode = {
    if (n == 1) head
    else nthNodeFromStart(n - 1, head.next)
  }
}
