package graphs.medium

import scala.collection.mutable

object Leet399EvaluateDivision {
  def calcEquation(equations: List[List[String]],
                   values: Array[Double],
                   queries: List[List[String]]): Array[Double] = {
    val graph = buildGraph(equations, values)
    queries.map { query =>
      if (graph.contains(query.head) && graph.contains(query.last) && query.head != query.last) {
        findAnswer(query.head, 1, graph, query.last, mutable.HashSet[String]())
      } else -1.0
    }.toArray
  }

  private def findAnswer(node: String, acc: Double,
                         graph: Map[String, Map[String, Double]],
                         end: String, visited: mutable.Set[String]): Double = {
    if (visited.contains(node)) -1
    else {
      visited.add(node)
      val neighborNode = graph(node).find(_._1 == end)
      if (neighborNode.isDefined) neighborNode.get._2 * acc
      else {
        val result = graph(node).map { neighbor =>
          if (neighbor._1 != node) findAnswer(neighbor._1, acc * neighbor._2, graph, end, visited) else -1
        }.filter(_ != -1)
        if (result.isEmpty) -1.0 else result.head
      }
    }
  }

  private def buildGraph(equations: List[List[String]], values: Array[Double]) = {
    equations.indices.flatMap { idx =>
      val equation = equations(idx)
      List((equation.head, equation.last, values(idx)),
        (equation.last, equation.head, 1.0 / values(idx)))
    }.groupBy(_._1).map { case (k, v) => (k, v.map(x => (x._2, x._3)).toMap) }
  }
}
