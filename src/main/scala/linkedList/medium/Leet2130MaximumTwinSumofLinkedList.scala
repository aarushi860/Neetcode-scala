package linkedList.medium

import linkedList.ListNode

object Leet2130MaximumTwinSumofLinkedList {
  def pairSum(head: ListNode): Int = {
    val midPoint = getMidPoint(head, head)
    val secondHalfReversedHead = reverseList(null, midPoint)
    getMax(-1, head, secondHalfReversedHead)
  }

  private def getMax(max: Int, list1: ListNode, list2: ListNode): Int = {
    if (list2 == null) max
    else {
      val sum = list1.x + list2.x
      getMax(Math.max(max, sum), list1.next, list2.next)
    }
  }

  private def reverseList(prev: ListNode, curr: ListNode): ListNode = {
    if (curr == null) prev
    else {
      val next = curr.next
      prev.next = curr
      reverseList(curr, next)
    }
  }

  private def getMidPoint(slow: ListNode, fast: ListNode): ListNode = {
    if (fast == null || fast.next == null) slow
    else getMidPoint(slow.next, fast.next.next)
  }
}
