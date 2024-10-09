package linkedList.medium

import linkedList.ListNode

object Leet92ReverseLinkedListII {
  def reverseBetween(head: ListNode, left: Int, right: Int): ListNode = {
    val dummy = new ListNode(-1)
    dummy.next = head
    val prev,con = getNthPointer(left, dummy)
    val curr,tail = prev.next
    val (updatedPrev, updatedCurr) = reverseList(right - left + 1, prev, curr)
    con.next = updatedPrev
    tail.next = updatedCurr
    dummy.next
  }

  private def reverseList(n: Int, prev: ListNode, curr: ListNode): (ListNode, ListNode) = {
    if (n == 0) (prev, curr)
    else {
      val next = curr.next
      curr.next = prev
      reverseList(n - 1, curr, next)
    }
  }

  private def getNthPointer(n: Int, head: ListNode): ListNode = {
    if (n == 1) head else getNthPointer(n - 1, head.next)
  }

}
