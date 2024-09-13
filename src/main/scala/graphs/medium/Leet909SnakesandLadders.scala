package graphs.medium

import scala.collection.mutable

object Leet909SnakesandLadders {
  def snakesAndLadders(board: Array[Array[Int]]): Int = {
    val n = board.length
    val queue = new mutable.Queue[Int]()
    val destination = Array.fill(n * n + 1)(-1)
    destination(1) = 0
    queue.addOne(1)
    while (queue.nonEmpty) {
      val top = queue.dequeue()
      (top + 1 to Math.min(top + 6, n * n)).foreach { x =>
        val (row, col) = getRowCol(x, n)
        val dest = if (board(row)(col) != -1) board(row)(col) else x
        if (destination(dest) == -1) {
          queue.addOne(dest)
          destination(dest) = destination(top) + 1
        }
      }
    }
    destination(n * n)
  }

  private def getRowCol(number: Int, n: Int) = {
    val row = n - ((number - 1) / n) - 1
    val col = if (row % 2 == n % 2) n - 1 - (number - 1) % n else (number - 1) % n
    (row, col)
  }

}
