package arrays.medium

object Leet2001NumberofPairsofInterchangeableRectangles {

  def gcf(a: Int, b: Int): Int = if (b == 0) a.abs else gcf(b, a % b)

  def minimal(rec: Array[Int]) = rec match {
    case Array(m, n) =>
      val f = gcf(m, n)
      (m / f, n / f)
  }

  def numPairs(n: Long): Long = n * (n - 1) / 2

  def interchangeableRectangles(rectangles: Array[Array[Int]]): Long =
    rectangles.groupBy(minimal).values.map(recs => numPairs(recs.size)).sum
}
