package graphs.medium

object Leet323NumberofConnectedComponentsinUndirectedGraph {
  def countComponents(n: Int, edges: Array[Array[Int]]): Int = {
    val rank = Array.fill(n)(1)
    val root: Array[Int] = (0 until n).map(i => i).toArray

    def findRoot(x: Int): Int = {
      if (x == root(x)) x
      else findRoot(root(x))
    }

    def union(edge: Array[Int]) = {
      val rootX = findRoot(edge(0))
      val rootY = findRoot(edge(1))
      if (rootX == rootY) 0
      else {
        if (rank(rootX) > rank(rootY)) root(rootY) = rootX
        else if (rank(rootY) > rank(rootX)) root(rootX) = rootY
        else {
          root(rootY) = rootX
          rank(rootX) = rank(rootX) + 1
        }
        1
      }
    }

    n - edges.map(union).sum
  }
}
