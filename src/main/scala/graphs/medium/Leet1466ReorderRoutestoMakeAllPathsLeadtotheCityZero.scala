package graphs.medium

object Leet1466ReorderRoutestoMakeAllPathsLeadtotheCityZero {
  def minReorder(n: Int, connections: Array[Array[Int]]): Int = {
    connectionsToCorrect(0, -1, buildGraph(connections))
  }

  private def connectionsToCorrect(node: Int, parent: Int, graph: Map[Int, Array[Edge]]): Int = {
    if (graph.contains(node)) {
      val neighbors = graph(node).filterNot(_.to == parent)
      val currentCount = neighbors.map(_.sign).sum
      val neighborCount =neighbors.map(neighbor => connectionsToCorrect(neighbor.to, node, graph)).sum
      currentCount + neighborCount
    } else 0
  }
  private def buildGraph(connections: Array[Array[Int]]) = {
    connections.flatMap { connection =>
      Seq(Edge(connection(1), connection(0), 0), Edge(connection(0), connection(1), 1))
    }.groupBy(_.from)
  }
}

case class Edge(from: Int, to: Int, sign: Int)
