package arrays

import scala.annotation.tailrec

object Leet605CanPlaceFlowers extends App {
  def canPlaceFlowers(flowerbed: Array[Int], n: Int): Boolean = {
    checkIfPossible(0, flowerbed, n, FLOWERBED.EMPTY)
  }

  @tailrec
  private def checkIfPossible(index: Int, flowerbed: Array[Int], n: Int, prev: Int): Boolean = {
    println(s"index is $index , n is $n")
    if (n == 0)
      true
    else {
      if (index < flowerbed.length - 1) {
        if (flowerbed(index) == FLOWERBED.OCCUPIED)
          checkIfPossible(index + 1, flowerbed, n, FLOWERBED.OCCUPIED)
        else if (prev == FLOWERBED.EMPTY && flowerbed(index + 1) == FLOWERBED.EMPTY)
          checkIfPossible(index + 1, flowerbed, n - 1, FLOWERBED.OCCUPIED)
        else checkIfPossible(index + 1, flowerbed, n, flowerbed(index))
      } else if (index == flowerbed.length - 1 && flowerbed(index) != FLOWERBED.OCCUPIED && prev == FLOWERBED.EMPTY)
        checkIfPossible(index + 1, flowerbed, n - 1, FLOWERBED.OCCUPIED)
      else false
    }
  }

}

object FLOWERBED {
  val EMPTY = 0
  val OCCUPIED = 1
}