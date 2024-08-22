package linkedList.easy

import linkedList.ListNode

object Leet21MergeTwoSortedLists {
  def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode = {
    val main = new ListNode(-1)
    val head = main
    merge(main, list1, list2)
    head.next
  }

  private def merge(main: ListNode, list1: ListNode, list2: ListNode): ListNode = {

    if (list1 == null && list2 == null) main
    else if (list1 == null || (list2!=null && list1.x > list2.x)) {
      main.next = list2
      merge(main.next, list1, list2.next)
    } else {
      main.next = list1
      merge(main.next, list1.next, list2)
    }
  }
}
