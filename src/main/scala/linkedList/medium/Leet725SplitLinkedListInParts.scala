package linkedList.medium

import linkedList.ListNode

object Leet725SplitLinkedListInParts {
  def splitListToParts(head: ListNode, k: Int): Array[ListNode] = {
    if (k == 0) Array(head)
    else {
      val n = lengthOfList(head, 0)
      val slots = (0 until k).map(_ => n / k)
      slots.foldLeft(head, Array.empty[ListNode], n % k) {
        case ((startNode, result, left), size) =>
          val (updatedSize, updatedLeft) = if (left != 0) (size + 1, left - 1) else (size, left)
          val next = if (startNode == null || updatedSize == 0) startNode
          else {
            val nthNode = getNthNode(updatedSize - 1, startNode)
            val next = nthNode.next
            nthNode.next = null
            next
          }
          (next, result :+ startNode, updatedLeft)
      }
    }._2
  }

  private def getNthNode(n: Int, head: ListNode): ListNode = {
    if (n == 0) head
    else getNthNode(n - 1, head.next)
  }

  private def lengthOfList(head: ListNode, n: Int): Int = {
    if (head == null) n
    else lengthOfList(head.next, n + 1)
  }
}
