package graphs.medium


//not working
object Leet1958CheckifMoveisLegal {
  def checkMove(board: Array[Array[Char]], rMove: Int, cMove: Int, color: Char): Boolean = {
    board(rMove)(cMove) = color
    checkVerticalUp(board, rMove, cMove) || checkVerticalDown(board, rMove, cMove) ||
      checkHorizontalLeft(board, rMove, cMove) || checkHorizontalRight(board, rMove, cMove) ||
      checkDiagnolLeftUp(board, rMove, cMove) || checkDiagnolRightUp(board, rMove, cMove) ||
      checkDiagnolLeftDown(board, rMove, cMove) || checkDiagnolRightDown(board, rMove, cMove)
  }

  private val complimentary = Map('B' -> 'W', 'W' -> 'B')

  private def checkVerticalUp(board: Array[Array[Char]], rMove: Int, cMove: Int) = {
    if (rMove >= 2) {
      if (board(rMove)(cMove) == board(0)(cMove)) {
        (1 until rMove).forall { idx =>
          board(idx)(cMove) == complimentary(board(rMove)(cMove))
        }
      } else false
    } else false
  }

  private def checkVerticalDown(board: Array[Array[Char]], rMove: Int, cMove: Int) = {
    val n = board.length
    if (n - 1 - rMove >= 2) {
      if (board(rMove)(cMove) == board(n - 1)(cMove)) {
        (rMove until n - 1).forall { idx =>
          board(idx)(cMove) == complimentary(board(rMove)(cMove))
        }
      } else false
    } else false
  }

  private def checkHorizontalLeft(board: Array[Array[Char]], rMove: Int, cMove: Int) = {
    if (cMove >= 2) {
      if (board(rMove)(cMove) == board(rMove)(0)) {
        (1 until cMove).forall { idx =>
          board(rMove)(idx) == complimentary(board(rMove)(cMove))
        }
      } else false
    } else false
  }

  private def checkHorizontalRight(board: Array[Array[Char]], rMove: Int, cMove: Int) = {
    val n = board(0).length
    if (n - 1 - cMove >= 2) {
      if (board(rMove)(cMove) == board(rMove)(n - 1)) {
        (cMove until n - 1).forall { idx =>
          board(cMove)(idx) == complimentary(board(rMove)(cMove))
        }
      } else false
    } else false
  }

  private def checkDiagnolLeftUp(board: Array[Array[Char]], rMove: Int, cMove: Int) = {
    if (rMove == cMove && cMove >= 2) {
      if (board(rMove)(cMove) == board(0)(0)) {
        (1 until cMove).forall { idx =>
          board(idx)(idx) == complimentary(board(rMove)(cMove))
        }
      } else false
    } else false
  }

  private def checkDiagnolLeftDown(board: Array[Array[Char]], rMove: Int, cMove: Int) = {
    val n = board.length
    if (rMove == cMove && n - 1 - cMove >= 2) {
      if (board(rMove)(cMove) == board(0)(n - 1)) {
        (rMove until n - 1).forall { row =>
          (cMove until 0 by -1).forall { col =>
            board(row)(col) == complimentary(board(rMove)(cMove))
          }
        }
      } else false
    } else false
  }

  private def checkDiagnolRightUp(board: Array[Array[Char]], rMove: Int, cMove: Int) = {
    val n = board.length
    if (rMove == cMove && n - 1 - cMove >= 2) {
      if (board(rMove)(cMove) == board(n - 1)(0)) {
        (rMove until 0 by -1).forall { row =>
          (cMove until n - 1).forall { col =>
            board(row)(col) == complimentary(board(rMove)(cMove))
          }
        }
      } else false
    } else false
  }

  private def checkDiagnolRightDown(board: Array[Array[Char]], rMove: Int, cMove: Int) = {
    val n = board.length
    if (rMove == cMove && n - 1 - cMove >= 2) {
      if (board(rMove)(cMove) == board(n - 1)(n - 1)) {
        (rMove until n - 1).forall { row =>
          (cMove until n - 1).forall { col =>
            board(row)(col) == complimentary(board(rMove)(cMove))
          }
        }
      } else false
    } else false
  }
}
