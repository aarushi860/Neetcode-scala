package stack.medium

import scala.collection.mutable

object Leet901OnlineStockSpan {
  class StockSpanner() {
    val stack = new mutable.Stack[Value]()

    def next(price: Int): Int = {
      getAcc(price, 1)
    }

    private def getAcc(price: Int, count: Int): Int = {
      if (stack.nonEmpty && stack.top.num <= price)
        getAcc(price, count + stack.pop().day)
      else {
        stack.push(Value(count,price))
        count
      }
    }
  }

  case class Value(day: Int, num: Int)
}
