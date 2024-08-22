package linkedList.easy

import linkedList.ListNode

object Leet83RemoveDuplicatesfromSortedList {
  def deleteDuplicates(head: ListNode): ListNode = {
    val curr=head
    delete(head)
    curr
  }

  private def delete(head:ListNode):Unit={
    if(head!=null && head.next!=null){
      if(head.x ==head.next.x){
        head.next=head.next.next
        delete(head)
      }else delete(head.next)
    }
  }
}
