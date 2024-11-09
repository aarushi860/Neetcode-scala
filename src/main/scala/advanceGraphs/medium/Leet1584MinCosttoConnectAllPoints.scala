package advanceGraphs.medium

import scala.collection.mutable

object Leet1584MinCosttoConnectAllPoints {
  def minCostConnectPoints(points: Array[Array[Int]]): Int = {
    val n = points.length
    val cellEdges = getEdges(points)
    val pq = new mutable.PriorityQueue[Cell]()(Ordering.by[Cell, Int](_.distance).reverse)
    pq.addAll(cellEdges)
    var count = 0
    var sum = 0
    val uf = new UnionFind(n)
    while (pq.nonEmpty && count != n - 1) {
      val cell = pq.dequeue()
      if (!uf.areConnected(cell.i, cell.j)) {
        uf.connectEdges(cell.i, cell.j)
        count += 1
        sum += cell.distance
      }
    }
    sum
  }

  private def getEdges(points: Array[Array[Int]]) = {
    points.indices.flatMap { idx =>
      val point = points(idx)
      (idx + 1 until points.length).map { i =>
        val distance = Math.abs(point.head - points(i).head) + Math.abs(point.last - points(i).last)
        Cell(idx, i, distance)
      }
    }
  }

  case class Cell(i: Int, j: Int, distance: Int)

  class UnionFind(n: Int) {
    val root = Array.ofDim[Int](n)
    val rank = Array.fill(n)(1)
    root.indices.foreach { i => root(i) = i }

    private def findRoot(x: Int): Int = {
      if (x == root(x))
        x
      else findRoot(root(x))
    }

    def connectEdges(x: Int, y: Int) = {
      val rootX = findRoot(x)
      val rootY = findRoot(y)
      if (rank(rootX) > rank(rootY)) {
        root(rootY) = rootX
      } else if (rank(rootY) > rank(rootX))
        root(rootX) = rootY
      else {
        rank(rootX) = rank(rootX) + 1
        root(rootY) = rootX
      }
    }

    def areConnected(x: Int, y: Int) = {
      findRoot(x) == findRoot(y)
    }
  }
}
