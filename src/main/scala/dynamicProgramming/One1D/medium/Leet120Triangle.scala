package dynamicProgramming.One1D.medium

import scala.collection.mutable

object Leet120Triangle {
  def minimumTotal(triangle: List[List[Int]]): Int = {
    val dp = mutable.Map[(Int, Int), Int]()
    getMin(0, 0, triangle, dp)
  }

  private def getMin(i: Int, j: Int, triangle: List[List[Int]], dp: mutable.Map[(Int, Int), Int]): Int = {
    if (!triangle.isDefinedAt(i) || !triangle(i).isDefinedAt(j)) 0
    else if (dp.contains((i, j))) dp(i, j)
    else {
      val result = triangle(i)(j) + Math.min(getMin(i + 1, j, triangle, dp), getMin(i + 1, j + 1, triangle, dp))
      dp.put((i, j), result)
      result
    }
  }
}
