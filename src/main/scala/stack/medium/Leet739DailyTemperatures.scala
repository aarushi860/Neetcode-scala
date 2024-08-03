package stack.medium

import scala.collection.mutable

object Leet739DailyTemperatures {
  def dailyTemperatures(temperatures: Array[Int]): Array[Int] = {
    val stack = mutable.Stack[Value]()
    val output = Array.fill(temperatures.length)(0)
    temperatures.zipWithIndex.foreach { case (temperature, day) =>
      while (stack.nonEmpty && stack.top.temp < temperature) {
        val value = stack.pop()
        output.update(value.idx, day - value.idx)
      }
      stack.push(Value(temperature, day))
    }
    output
  }
}

case class Value(temp: Int, idx: Int)