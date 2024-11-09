package advanceGraphs.medium

import scala.collection.mutable

object Leet1514PathwithMaximumProbability {
  def maxProbability(n: Int, edges: Array[Array[Int]],
                     succProb: Array[Double],
                     start_node: Int,
                     end_node: Int): Double = {
    val distance = Array.fill(n)(0.0)
    distance(start_node) = 1
    val graph = buildGraph(edges, succProb)
    val queue = new mutable.PriorityQueue[Edge]()(Ordering.by[Edge, Double](_.probability))
    queue.addOne(Edge(start_node, 1.0))
    val visited = Array.fill(n)(false)
    while (queue.nonEmpty && queue.head.node != end_node) {
      val edge = queue.dequeue()
      if (!visited(edge.node)) {
        graph.get(edge.node).foreach { neighbors =>
          neighbors.foreach { neighbor =>
            if (distance(neighbor.node) < edge.probability * neighbor.probability) {
              distance(neighbor.node) = edge.probability * neighbor.probability
              queue.addOne(Edge(neighbor.node, distance(neighbor.node)))
            }
          }
        }
      }
      visited(edge.node) = true
    }
    distance(end_node)
  }

  private def buildGraph(edges: Array[Array[Int]], succProb: Array[Double]) = {
    edges.indices.flatMap { idx =>
      List((edges(idx)(0), Edge(edges(idx)(1), succProb(idx))),
        (edges(idx)(1), Edge(edges(idx)(0), succProb(idx))))
    }.groupBy(_._1).map { case (k, v) => (k, v.map(_._2)) }
  }

  case class Edge(node: Int, probability: Double)
}
