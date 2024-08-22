package linkedList.easy

import linkedList.ListNode

object Leet160IntersectionofTwoLinkedLists {
  def getIntersectionNode(headA: ListNode, headB: ListNode): ListNode = {
    getNode(headA, headB, headA, headB)
  }

  private def getNode(headA: ListNode, headB: ListNode, a: ListNode, b: ListNode): ListNode = {
    if (a == b) a
    else {
      if (a == null) getNode(headA, headB, headB, b.next)
      else if (b == null) getNode(headA, headB, a.next, headA)
      else getNode(headA, headB, a.next, b.next)
    }
  }
}
