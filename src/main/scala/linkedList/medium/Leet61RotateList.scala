package linkedList.medium

import linkedList.ListNode

object Leet61RotateList {
  def rotateRight(head: ListNode, k: Int): ListNode = {
    if (head == null) null
    else {
      val n = countNodes(head, 0)
      val x = n - k % n
      if (n == 1 || k == 0 || n == k) head
      else {
        val secondHead = getSecondHead(head, x - 1)
        val copy = new ListNode(-1)
        copy.next = secondHead
        join(copy, head)
        copy.next
      }
    }
  }

  private def join(secondHead: ListNode, head: ListNode): Unit = {
    if (secondHead.next == null) secondHead.next = head
    else join(secondHead.next, head)
  }

  private def getSecondHead(head: ListNode, k: Int): ListNode = {
    if (k == 0) {
      val result = head.next
      head.next = null
      result
    } else getSecondHead(head.next, k - 1)
  }

  private def countNodes(head: ListNode, n: Int): Int = {
    if (head == null) n
    else countNodes(head.next, n + 1)
  }
}
