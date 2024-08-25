package trees.medium

//not working
object Leet427ConstructQuadTree {
  def construct(grid: Array[Array[Int]]): Node = {
    val n = grid.length
    checkAndConstruct(0, n - 1, 0, n - 1, grid)
  }

  private def checkAndConstruct(startRow: Int, endRow: Int, startCol: Int, endCol: Int, grid: Array[Array[Int]]): Node = {
    if (startRow > endRow) null
    else {
      if (isValidSquare(startRow, endRow, startCol, endCol, grid))
        new Node(grid(startRow)(startCol), true)
      else {
        val node = new Node(grid(startRow)(startCol), false)
        node.topLeft = checkAndConstruct(startRow, endRow / 2, startCol, endCol / 2, grid)
        node.topRight = checkAndConstruct(startRow, endRow / 2, endCol / 2, endCol, grid)
        node.bottomLeft = checkAndConstruct(endRow / 2, endRow, startCol, endCol / 2, grid)
        node.bottomRight = checkAndConstruct(endRow / 2, endRow, endCol / 2, endCol / 2, grid)
        node
      }
    }
  }

  private def isValidSquare(startRow: Int, endRow: Int, startCol: Int, endCol: Int, grid: Array[Array[Int]]): Boolean = {
    val value = grid(startRow)(startCol)
    (startRow to endRow).forall {row=>
      (startCol to endCol).forall {col =>
        grid(row)(col)==value
      }
    }
  }

  class Node(var _value: Int, var _isLeaf: Boolean) {
    var value: Int = _value
    var isLeaf: Boolean = _isLeaf
    var topLeft: Node = null
    var topRight: Node = null
    var bottomLeft: Node = null
    var bottomRight: Node = null
  }
}
