package linkedList.easy

import linkedList.ListNode

object Leet206ReverseLinkedList {
  def reverseList(head: ListNode): ListNode = {
   reverse(null,head)
  }

  private def reverse(prev:ListNode,curr:ListNode):ListNode={
    if(curr==null)prev
    else{
      val next=curr.next
      curr.next=prev
      reverse(curr,next)
    }
  }

}
