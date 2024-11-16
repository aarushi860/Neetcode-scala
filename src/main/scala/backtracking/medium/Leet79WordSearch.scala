package backtracking.medium

import scala.collection.mutable

object Leet79WordSearch {
  def exist(board: Array[Array[Char]], word: String): Boolean = {
    val ch = word.head
    board.indices.exists { i =>
      board(i).indices.exists { j =>
        board(i)(j) == ch && exists(board, word, i, j, 1, Set.empty)
      }
    }
  }

  private val DIRECTIONS = List((-1, 0), (0, -1), (1, 0), (0, 1))

  def exists(board: Array[Array[Char]], word: String, x: Int, y: Int,
             idx: Int, visited: Set[(Int, Int)]): Boolean = {
    if (idx == word.length) true
    else {
      DIRECTIONS.exists { direction =>
        val row = direction._1 + x
        val col = direction._2 + y
        if (board.isDefinedAt(row) && board(row).isDefinedAt(col) && !visited.contains((row, col)) && word(idx) == board(row)(col)) {
          exists(board, word, row, col, idx + 1, visited.+((x, y)))
        } else false
      }
    }
  }
}
