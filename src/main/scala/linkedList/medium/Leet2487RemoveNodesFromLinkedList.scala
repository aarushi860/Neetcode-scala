package linkedList.medium

import linkedList.ListNode

import scala.collection.mutable

object Leet2487RemoveNodesFromLinkedList {
  def removeNodes(head: ListNode): ListNode = {
    val stack: mutable.Stack[ListNode] = mutable.Stack.empty
    buildLinkedList(head, stack)
    if (stack.nonEmpty) getBottomElementInStack(stack) else null
  }

  private def getBottomElementInStack(stack: mutable.Stack[ListNode]): ListNode = {
    val top = stack.pop()
    if (stack.isEmpty) top
    else getBottomElementInStack(stack)
  }

  private def buildLinkedList(head: ListNode, stack: mutable.Stack[ListNode]): mutable.Stack[ListNode] = {
    if (head == null) stack
    else {
      pushToStack(head, stack)
      buildLinkedList(head.next, stack)
    }
  }

  private def pushToStack(head: ListNode, stack: mutable.Stack[ListNode]): mutable.Stack[ListNode] = {
    if (stack.isEmpty || stack.top.x >= head.x) {
      if (stack.nonEmpty)
        stack.top.next = head
      stack.push(head)
    }
    else {
      stack.pop()
      pushToStack(head, stack)
    }
  }

}
