package advanceGraphs.hard

object Leet2709GreatestCommonDivisorTraversal {
  def canTraverseAllPairs(nums: Array[Int]): Boolean = {
    val uf = new UnionFind(nums.length)
    nums.indices.foreach { idx1 =>
      val idx2=idx1+1
      val gcd = getGCD(nums(idx1), nums(idx2))
      if (gcd > 1) uf.union(idx1, idx2)

    }
    nums.indices.groupBy { x => uf.find(x)
    }.size == 1
  }

  private def getGCD(x: Int, y: Int): Int = {
    if (x == 0) y
    else if (y == 0) x
    else {
      if (x > y) {
        if (x % y == 0) y else getGCD(x - y, y)
      } else {
        if (y % x == 0) x else getGCD(x, y - x)
      }
    }
  }

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
      }
    }
  }
}
