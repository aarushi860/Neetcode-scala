package graphs.medium

import scala.collection.mutable

object Leet802FindEventualSafeStates {
  def eventualSafeNodes(graph: Array[Array[Int]]): List[Int] = {
    val indegree = Array.ofDim[Int](graph.length)

    val map: Map[Int, Array[Int]] = graph.indices.flatMap { idx =>
      val outgoing = graph(idx)
      indegree(idx) = outgoing.length
      outgoing.map(eachOUtgoing => (eachOUtgoing, idx))
    }.groupBy(_._1).map(x => (x._1, x._2.map(_._2).toArray))

    val queue = new mutable.Queue[Int]()
    indegree.indices.filter(idx => indegree(idx) == 0).foreach(queue.addOne)
    val result: mutable.SortedSet[Int] = mutable.SortedSet.empty

    while (queue.nonEmpty) {
      val top = queue.dequeue()
      result.addOne(top)
      val allIncomingEdges = map.getOrElse(top, Array.empty[Int])
      allIncomingEdges.foreach { edge =>
        indegree.update(edge, indegree(edge) - 1)
        if (indegree(edge) == 0)
          queue.addOne(edge)
      }
    }
    result.toList
  }

}
