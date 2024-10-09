package linkedList.medium

import linkedList.ListNode

object Leet622DesignCircularQueue {
  class MyCircularQueue(_k: Int) {

    val capacity=_k
    var current=0
    var root:ListNode=null
    var last:ListNode=null
    def enQueue(value: Int): Boolean = {
      if(current==capacity)false
      else {
        if (root == null) {
          root = new ListNode(value)
          last = root
        } else {
          val node = new ListNode(value)
          last.next = node
          last = last.next
        }
        current+=1
        true
      }
    }

    def deQueue(): Boolean = {
      if(current==0 || root== null)false
      else{
        root=root.next
        current-=1
        true
      }
    }

    def Front(): Int = {
      if(root==null)-1
      else root.x
    }

    def Rear(): Int = {
      if(root==null)-1
      else last.x
    }

    def isEmpty(): Boolean = {
      root == null
    }

    def isFull(): Boolean = {
      current == capacity
    }

  }
}
