package linkedList.easy

import linkedList.ListNode

object Leet203RemoveLinkedListElements {
  def removeElements(head: ListNode, `val`: Int): ListNode = {
    val prev = new ListNode(-1)
    val dummy = prev
    prev.next = head
    delete(prev, `val`)
    dummy.next
  }

  private def delete(head: ListNode, `val`: Int): Unit = {
    if (head != null && head.next != null) {
      if (head.next.x == `val`) {
        head.next = head.next.next
        delete(head, `val`)
      } else delete(head.next, `val`)
    }
  }
}
