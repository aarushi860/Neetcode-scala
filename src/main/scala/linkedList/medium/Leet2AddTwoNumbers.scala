package linkedList.medium

import linkedList.ListNode

object Leet2AddTwoNumbers {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    val node = new ListNode(0)
    val result = node
    add(0, l1, l2, result)
    node.next
  }

  private def add(carry: Int, l1: ListNode, l2: ListNode, result: ListNode): Unit = {
    if (l1 == null && l2 == null) {
      if (carry == 1) result.next = new ListNode(1)
    }
    else {
      val sum = if (l1 == null) l2.x
      else if (l2 == null) l1.x
      else l1.x + l2.x
      val node = new ListNode((sum + carry) % 10)
      result.next = node
      add((sum + carry) / 10, if (l1 == null) null else l1.next, if (l2 == null) null else l2.next, node)
    }
  }


}
