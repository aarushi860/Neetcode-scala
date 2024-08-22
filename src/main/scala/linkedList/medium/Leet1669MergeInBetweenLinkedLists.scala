package linkedList.medium

import linkedList.ListNode

object Leet1669MergeInBetweenLinkedLists {
  def mergeInBetween(list1: ListNode, a: Int, b: Int, list2: ListNode): ListNode = {
    val prev = new ListNode(-1)
    prev.next = list1
    merge(a, b - a + 1, prev, list2)
    prev.next
  }


  private def merge(a: Int, b: Int, list1: ListNode, list2: ListNode): Unit = {
    if (a == 0) {
      val head = getStartingNode(b, list1)
      //   println(s"head is ${head.x}, list1 is ${list1.x}")
      join(list1, list2, head.next)
    } else merge(a - 1, b, list1.next, list2)
  }

  private def join(listFirstHalfEnd: ListNode, list2: ListNode, listSecondHalfStart: ListNode) = {
    listFirstHalfEnd.next = list2
    val list2EndPOint = getEndPoint(list2)
    list2EndPOint.next = listSecondHalfStart
  }

  private def getEndPoint(list: ListNode): ListNode = {
    if (list.next == null) list
    else getEndPoint(list.next)
  }

  private def getStartingNode(b: Int, list1: ListNode): ListNode = {
    if (b == 0) list1
    else getStartingNode(b - 1, list1.next)
  }
}
