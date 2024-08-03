package stack.medium

import scala.collection.mutable

object Leet735AsteroidCollision {
  def asteroidCollision(asteroids: Array[Int]): Array[Int] = {
    val stack = new mutable.Stack[Int]()
    asteroids.foreach { num =>
      compareAndCollide(stack, num)
    }
    stack.toArray.reverse
  }

  private def compareAndCollide(stack: mutable.Stack[Int], num: Int): Unit = {
    if (num != 0) {
      if (stack.nonEmpty && stack.top > 0 && num < 0) {
        val newNum = collide(stack.pop(), num)
        compareAndCollide(stack, newNum)
      } else stack.push(num)
    }
  }

  private def collide(positiveNum: Int, negativeNum: Int): Int = {
    if (positiveNum > Math.abs(negativeNum)) positiveNum
    else if (positiveNum == Math.abs(negativeNum)) 0
    else negativeNum
  }


}
