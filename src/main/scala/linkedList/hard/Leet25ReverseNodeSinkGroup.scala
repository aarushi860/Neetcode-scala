package linkedList.hard

import linkedList.ListNode

//class Leet25ReverseNodeSinkGroup {
//  def reverseKGroup(head: ListNode, k: Int): ListNode = {
//    val dummy = new ListNode(-1)
//    dummy.next = head
//
//  }
//
//
//  private def reverseList(curr: ListNode, prev: ListNode, k: Int): (ListNode, ListNode) = {
//    if ((k > 1 && curr == null) || k == 1) (prev, curr)
//    else {
//      val next = curr.next
//      curr.next = prev
//      reverseList(next, curr, k - 1)
//    }
//  }
//}
