package binarySearch.medium

object Leet74Searcha2DMatrix {
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    find(matrix, 0, matrix.length * matrix.head.length - 1, target)
  }

  def find(matrix: Array[Array[Int]], left: Int, right: Int, target: Int): Boolean = {
    if (left <= right) {
      val mid = (left + right) / 2
      val totalCols = matrix.head.length
      val row = mid / totalCols
      val col = mid % totalCols
      matrix(row)(col) match {
        case i if i == target => true
        case i if i > target => find(matrix, left, mid - 1, target)
        case _ => find(matrix, mid + 1, right, target)
      }
    } else false
  }
}
