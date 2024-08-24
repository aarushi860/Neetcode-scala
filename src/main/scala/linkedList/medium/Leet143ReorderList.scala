package linkedList.medium

import linkedList.ListNode

object Leet143ReorderList {
  def reorderList(head: ListNode): Unit = {
    val midNode = getMidPoint(head, head)
    // println(s"midNode ${midNode.x}")
    val secondHalfReversedHead = reverseSecondHalf(null, midNode)
    // println(s"head of second half reversed ${secondHalfReversedHead.x}")
    joinLists(head, secondHalfReversedHead)
  }

  private def joinLists(list1: ListNode, list2: ListNode): Unit = {
    if (list2 == null) {
      if (list1 != null) {
        // println(s"list ${list1.x}")
        list1.next = null
      }
    }
    else {
      val next1 = list1.next
      val next2 = list2.next
      list1.next = list2
      list2.next = next1
      //   println(s"list 1 is ${list1.x} , list 2 is ${list2.x}")
      joinLists(next1, next2)
    }
  }

  private def reverseSecondHalf(prev: ListNode, head: ListNode): ListNode = {
    if (head == null) prev
    else {
      val next = head.next
      head.next = prev
      reverseSecondHalf(head, next)
    }
  }

  private def getMidPoint(slow: ListNode, fast: ListNode): ListNode = {
    if (fast == null || fast.next == null) slow
    else getMidPoint(slow.next, fast.next.next)
  }
}
