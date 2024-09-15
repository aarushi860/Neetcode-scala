package graphs.medium

import scala.collection.mutable

object Leet210CourseScheduleII {
  def findOrder(numCourses: Int, prerequisites: Array[Array[Int]]): Array[Int] = {
    val (indegree, graph) = buildGraph(numCourses, prerequisites)
    val queue = new mutable.Queue[Int]()
    indegree.indices.filter(idx => indegree(idx) == 0).foreach(queue.addOne)
    val output = mutable.ListBuffer.empty[Int]
    while (queue.nonEmpty) {
      val top = queue.dequeue()
      output.addOne(top)
      val incomingEdges = graph.getOrElse(top, Array.empty[Int])
      incomingEdges.foreach { edge =>
        indegree.update(edge, indegree(edge) - 1)
        if (indegree(edge) == 0)
          queue.addOne(edge)
      }
    }
    if (output.size == numCourses) output.toArray
    else Array.empty[Int]
  }

  private def buildGraph(numCourses: Int, prerequisites: Array[Array[Int]]) = {
    val indegree = Array.ofDim[Int](numCourses)
    val graph = prerequisites.map { pair =>
      indegree.update(pair(0), indegree(pair(0)) + 1)
      (pair(1), pair(0))
    }.groupBy(_._1).map(x => (x._1, x._2.map(_._2)))
    (indegree, graph)
  }
}
