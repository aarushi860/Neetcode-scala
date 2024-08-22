package linkedList.easy

import linkedList.ListNode

object Leet876MiddleoftheLinkedList {
  def middleNode(head: ListNode): ListNode = {
    getMiddle(head, head)
  }

  private def getMiddle(slow: ListNode, fast: ListNode): ListNode = {
    if (fast == null || fast.next == null) slow
    else getMiddle(slow.next, fast.next.next)
  }
}
