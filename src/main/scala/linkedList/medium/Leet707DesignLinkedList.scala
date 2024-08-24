package linkedList.medium

import linkedList.ListNode

object Leet707DesignLinkedList {
  class MyLinkedList() {

    var root: ListNode = null

    def get(index: Int): Int = {
      if (index < 0) -1
      else {
        val listNodeOpt = getAtIdx(index, root)
        listNodeOpt.map(_.x).getOrElse(-1)
      }
    }

    private def getAtIdx(idx: Int, node: ListNode): Option[ListNode] = {
      if (node == null && idx > 0) None
      else if (idx == 0) Option(node)
      else getAtIdx(idx - 1, node.next)
    }

    def addAtHead(`val`: Int): Unit = {
      val head = new ListNode(`val`)
      head.next = root
      root = head
    }

    def addAtTail(`val`: Int): Unit = {
      if (root == null)
        root = new ListNode(`val`)
      else insertLast(root, `val`)
    }

    private def insertLast(node: ListNode, `val`: Int): Unit = {
      if (node.next == null)
        node.next = new ListNode(`val`)
      else insertLast(node.next, `val`)
    }

    def addAtIndex(index: Int, `val`: Int): Unit = {
      val prev = new ListNode(-1)
      prev.next = root
      val nodeBefore = getAtIdx(index, prev)
      val newNode = new ListNode(`val`)
      if (nodeBefore.isDefined) {
        val next = nodeBefore.get.next
        nodeBefore.get.next = newNode
        newNode.next = next
        root = prev.next
      }
    }

    def deleteAtIndex(index: Int): Unit = {
      val prev = new ListNode(-1)
      prev.next = root
      val nodeBefore = getAtIdx(index, prev)
      if (nodeBefore.isDefined && nodeBefore.get.next != null) {
        nodeBefore.get.next = nodeBefore.get.next.next
        root = prev.next
      }
    }
  }

}
