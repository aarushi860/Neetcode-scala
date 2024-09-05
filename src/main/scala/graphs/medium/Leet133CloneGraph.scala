package graphs.medium

import scala.collection.mutable

object Leet133CloneGraph {

  val visited: mutable.Map[Node, Node] = mutable.Map.empty

  def cloneGraph(graph: Node): Node = {
    if (graph == null) null
    else if (visited.contains(graph)) {
      //  println(s"graph value ${graph.value}")
      visited(graph)
    }
    else {
      val newNode = new Node(graph.value)
      visited.put(graph, newNode)
      val newNeighbors = graph.neighbors.map(cloneGraph)
      newNode.neighbors = newNeighbors
      newNode
    }
  }
}


class Node(var _value: Int) {

  var value: Int = _value

  var neighbors: List[Node] = List()

}