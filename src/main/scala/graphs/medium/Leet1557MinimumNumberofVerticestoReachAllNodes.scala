package graphs.medium

import scala.collection.mutable

object Leet1557MinimumNumberofVerticestoReachAllNodes {
  def findSmallestSetOfVertices(n: Int, edges: List[List[Int]]): List[Int] = {
    val indegree = Array.ofDim[Int](n)
    edges.foreach { edge =>indegree.update(edge.last, indegree(edge.last) + 1)}
    indegree.indices.filter { idx => indegree(idx) == 0}.toList
  }

}
