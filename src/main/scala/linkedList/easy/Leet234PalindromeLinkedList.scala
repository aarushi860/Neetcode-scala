package linkedList.easy

import jdk.javadoc.internal.doclets.formats.html.markup.Head
import linkedList.ListNode

object Leet234PalindromeLinkedList {
  def isPalindrome(head: ListNode): Boolean = {
    val firstHalf=getFirstHalf(head)
    val reversedList=reverseSecondHalf(firstHalf)
    val p1=head
    val p2=reversedList
    val result=compareLists(p1,p2)
    reverseSecondHalf(reversedList)
    result
  }

  private def getFirstHalf(head:ListNode)={
    getMidPoint(head,head)
  }

  private def getMidPoint(slow:ListNode,fast:ListNode):ListNode={
    if(fast ==null || fast.next == null)slow
    getMidPoint(slow.next,fast.next.next)
  }

  private def reverseSecondHalf(midPoint:ListNode)={
    reverse(null,midPoint)
  }

  private def reverse(prev:ListNode,curr:ListNode):ListNode={
    if(curr==null)prev
    else{
      val next=curr.next
      curr.next=prev
      reverse(curr,next)
    }
  }
  private def compareLists(list1: ListNode,list2:ListNode):Boolean={
    if(list2==null) true
    else {
      if(list1.x!=list2.x)false
      else compareLists(list1.next,list2.next)
    }
  }

}
