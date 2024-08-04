package stack.medium

import scala.collection.mutable

object Leet341FlattenNestedListIterator {

  // This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
  trait NestedInteger {

    // Return true if this NestedInteger holds a single integer, rather than a nested list.
    def isInteger: Boolean

    // Return the single integer that this NestedInteger holds, if it holds a single integer.
    def getInteger: Int

    // Set this NestedInteger to hold a single integer.
    def setInteger(i: Int): Unit

    // Return the nested list that this NestedInteger holds, if it holds a nested list.
    def getList: Array[NestedInteger]

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    def add(ni: NestedInteger): Unit
  }

  class NestedIterator(_nestedList: List[NestedInteger]) {

    val stack = new mutable.Stack[Int]()
    init(_nestedList.toArray)

    private def init(nestedList: Array[NestedInteger]): Unit = {
      nestedList.reverse.foreach(x =>
        if (!x.isInteger) init(x.getList)
        else stack.push(x.getInteger)
      )
    }

    def next(): Int = {
      stack.pop()
    }

    def hasNext(): Boolean = {
      stack.nonEmpty
    }


  }

  /**
   * Your NestedIterator object will be instantiated and called as such:
   * var obj = new NestedIterator(nestedList)
   * var param_1 = obj.next()
   * var param_2 = obj.hasNext()
   */
}
