package linkedList.medium

import linkedList.ListNode

object Leet24SwapNodesinPairs {
  def swapPairs(head: ListNode): ListNode = {
    val prev = new ListNode(-1)
    prev.next = head
    swap(prev)
    prev.next
  }

  private def swap(head: ListNode): () = {
    if (head == null || head.next == null || head.next.next == null) ()
    else {
      val pair1 = head.next
      val pair2 = head.next.next
      val third = head.next.next.next
      head.next = pair2
      pair2.next = pair1
      pair1.next = third
      swap(pair1)
    }
  }
}
