package stack.easy

import scala.collection.mutable

object Leet682BaseballGame {
  def calPoints(operations: Array[String]): Int = {
    val stack = new mutable.Stack[Int]()
    val operators = Set("D", "C", "+")
    operations.foreach { operation =>
      if (operators.contains(operation)) {
        performOperations(stack, operation)
      } else stack.push(operation.toInt)
    }
    stack.sum
  }

  private def performOperations(stack: mutable.Stack[Int], operation: String) = {
    println(s"Stack is ${stack.mkString(",")}, operation is ${operation}")
    operation match {
      case "D" =>
        val double = stack.top * 2
        stack.push(double)
      case "C" =>
        stack.pop()
      case "+" =>
        val firstElement: Int = stack.pop()
        val secondElement: Int = stack.top
        val add = firstElement + secondElement
        stack.push(firstElement)
        stack.push(add)
    }
  }
}
