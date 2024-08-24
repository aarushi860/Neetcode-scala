package linkedList.easy

import linkedList.ListNode

object Leet141LinkedListCycle {
  def hasCycle(head: ListNode): Boolean = {
    hasCycle(head, head)
  }

  private def hasCycle(slow: ListNode, fast: ListNode): Boolean = {
    if (fast == null || fast.next == null) false
    else if (fast == slow) true
    else hasCycle(slow.next, fast.next.next)
  }
}
