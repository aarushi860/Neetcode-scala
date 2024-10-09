package linkedList.hard

import linkedList.ListNode

import scala.collection.mutable

object Leet23MergekSortedLists {
  def mergeKLists(lists: Array[ListNode]): ListNode = {
    var head = new ListNode(-1)
    val dummy = head
    val pq = new mutable.PriorityQueue[ListNode]()(Ordering.by[ListNode, Int](_.x).reverse)
    lists.foreach(element => if (element != null) pq.addOne(element))
    while (pq.nonEmpty) {
      val node = pq.dequeue()
      head.next = node
      head = head.next
      if (node.next != null) pq.addOne(node.next)
    }
    dummy.next
  }

}
