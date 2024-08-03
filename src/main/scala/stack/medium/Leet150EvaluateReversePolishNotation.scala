package stack.medium

import scala.collection.mutable

object Leet150EvaluateReversePolishNotation {
  def evalRPN(tokens: Array[String]): Int = {
    val operators = Set("+", "-", "*", "/")
    val stack = new mutable.Stack[Int]()
    tokens.foreach { token =>
      if (operators.contains(token)) {
        stack.push(evaluateExpression(stack, token))
      } else stack.push(token.toInt)
    }
    stack.head
  }

  private def evaluateExpression(stack: mutable.Stack[Int], operator: String): Int = {
    val b = stack.pop()
    val a = stack.pop()
    operator match {
      case "+" => b + a
      case "-" => a - b
      case "/" => a / b
      case "*" => a * b
    }
  }
}
