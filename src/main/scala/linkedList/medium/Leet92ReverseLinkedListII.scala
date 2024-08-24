package linkedList.medium

import linkedList.ListNode

object Leet92ReverseLinkedListII {
  def reverseBetween(head: ListNode, left: Int, right: Int): ListNode = {
    val prev= new ListNode(-1)
    prev.next=head
    reverse(prev,left,right-left)
    prev.next
  }

  def reverse(head:ListNode,left:Int, right:Int)={
    if(left==1){
      val lastElement=head.next
      val (reversedHead,next)=reverse(head.next,null,head.next.next,right)
      head.next=reversedHead
      lastElement.next=next
    }
  }
  private def reverse(head:ListNode,prev:ListNode,next:ListNode,counter:Int):(ListNode,ListNode)={
    if(counter==0)(prev,next)
    else {
      val next=head.next
      prev.next=head
      reverse(next,head,next.next,counter-1)
    }
  }
}
