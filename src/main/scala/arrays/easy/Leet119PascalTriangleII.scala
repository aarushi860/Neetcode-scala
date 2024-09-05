package arrays.easy

object
Leet119PascalTriangleII extends App {

  def getRow(rowIndex: Int): List[Int] = {
    if (rowIndex == 0) List(1)
    else {
      (1 to rowIndex ).foldLeft(IndexedSeq[Int]()) { (prevArray, currentIdx) =>
        getList(prevArray, currentIdx)
      }.toList
    }
  }

  def getList(prevArray: IndexedSeq[Int], idx: Int) = {
    val list = (1 to idx - 1).map { indice =>
      prevArray(indice - 1) + prevArray(indice)
    }
    1 +: list :+ 1
  }

  println(getRow(3))
}
