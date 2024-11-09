package advanceGraphs.hard

import scala.collection.mutable

object Leet2421NumberofGoodPaths {
  def numberOfGoodPaths(vals: Array[Int], edges: Array[Array[Int]]): Int = {

    val graph = edges.flatMap { edge =>
      List((edge.head, edge.last), (edge.last, edge.head))
    }.groupBy(_._1).map(x => (x._1, x._2.map(_._2)))

    val sortedValueNodes = new mutable.TreeMap[Int, IndexedSeq[Int]]()
    val valuesNodes = vals.indices.map { idx =>
      (vals(idx), idx)
    }.groupBy(_._1).map(x => (x._1, x._2.map(_._2)))
    sortedValueNodes.addAll(valuesNodes)
    val uf = new UnionFind(vals.length)
    sortedValueNodes.map { case (value, nodes) =>
      nodes.foreach { node =>
        graph.get(node).foreach { neighbors =>
          neighbors.foreach { neighbor =>
            if (vals(neighbor) <= vals(node)) {
              uf.union(node, neighbor)
            }
          }
        }
      }

      val groupedNodesCount = nodes.map { node =>
        (uf.find(node), 1)
      }.groupBy(_._1).map(x => (x._1, x._2.map(_._2).sum))

      groupedNodesCount.values .map{value =>
        (value * (value + 1)) / 2
      }.sum
    }.sum
  }

  class UnionFind(n: Int) {
    val root = Array.ofDim[Int](n)
    val rank = Array.fill(n)(1)
    root.indices.foreach { idx =>
      root(idx) = idx
    }

    def find(x: Int): Int = {
      if (x == root(x)) x
      else find(root(x))
    }

    def union(x: Int, y: Int) = {
      val rootX = find(x)
      val rootY = find(y)
      if (rootX != rootY) {
        if (rank(rootX) > rank(rootY)) root(rootY) = rootX
        else if (rank(rootX) < rank(rootY)) root(rootX) = rootY
        else {
          root(rootY) = rootX
          rank(rootX) += 1
        }
      }
    }
  }
}
