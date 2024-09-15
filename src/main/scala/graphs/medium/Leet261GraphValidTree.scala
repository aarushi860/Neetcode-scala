package graphs.medium

object Leet261GraphValidTree {
  def validTree(n: Int, edges: Array[Array[Int]]): Boolean = {
    val graph = buildGraph(edges, n)
    val visited = Array.ofDim[Boolean](n)
    dfs(0, graph, visited, -1) && visited.forall(_ == true)
  }

  private def dfs(node: Int, graph: Map[Int, Array[Int]], visited: Array[Boolean], parent: Int): Boolean = {
    if (visited(node))
      false
    else {
      visited(node) = true
      val incomingEdges = graph.getOrElse(node, Array.empty[Int])
      incomingEdges.filterNot(_ == parent).forall { edge =>
        dfs(edge, graph, visited, node)
      }
    }
  }

  private def buildGraph(edges: Array[Array[Int]], n: Int) = {
    edges.flatMap { edge =>
      Seq((edge(0), edge(1)), (edge(1), edge(0)))
    }.groupBy(_._1).map(x => (x._1, x._2.map(_._2)))
  }

}
