package advanceGraphs.hard

object Leet1489FindCriticalandPseudoCriticalEdgesinMST {
  def findCriticalAndPseudoCriticalEdges(n: Int, edges: Array[Array[Int]]): List[List[Int]] = {
    val allEdges = edges.zipWithIndex.map { case (edge, idx) =>
      Edge(edge(0), edge(1), edge(2), idx)
    }.sortBy(_.weight)

    val ufMST = new UnionFind(n)
    val mstWght = allEdges.map { edge =>
      if (ufMST.union(edge.x, edge.y)) edge.weight else 0
    }.sum

    val (critical, pseudo) = allEdges.foldLeft(List.empty[Int], List.empty[Int]) {
      case ((critical, pseudo), edge) =>
        val otherEdges = allEdges.filterNot(_.idx == edge.idx)
        val uf = new UnionFind(n)
        val weightWithoutCurrentEdge = otherEdges.map { edge =>
          if (uf.union(edge.x, edge.y)) edge.weight else 0
        }.sum
        val isConnected = (0 until n).groupBy(x => uf.find(x)).size == 1
        if (!isConnected || weightWithoutCurrentEdge > mstWght)
          ((critical :+ edge.idx), pseudo)
        else {
          val forcedUf = new UnionFind(n)
          forcedUf.union(edge.x, edge.y)
          val forcedWeight = allEdges.filterNot(_.idx == edge.idx).map { edge =>
            if (forcedUf.union(edge.x, edge.y)) edge.weight else 0
          }.sum + edge.weight
          if (forcedWeight == mstWght) (critical, pseudo :+ edge.idx)
          else (critical, pseudo)
        }
    }
    List(critical , pseudo)
  }

  case class Edge(x: Int, y: Int, weight: Int, idx: Int)

  class UnionFind(n: Int) {

    val rank = Array.fill(n)(1)
    val root = Array.ofDim[Int](n)
    root.indices.foreach(idx => root(idx) = idx)

    def find(x: Int): Int = {
      if (x == root(x)) x
      else find(root(x))
    }

    def union(x: Int, y: Int) = {
      val rootX = find(x)
      val rootY = find(y)
      if (rootX != rootY) {
        if (rank(rootX) > rank(rootY)) root(rootY) = rootX
        else if (rank(rootY) > rank(rootX)) root(rootX) = rootY
        else {
          rank(rootX) += 1
          root(rootY) = rootX
        }
        true
      } else false
    }
  }
}
