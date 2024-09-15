package graphs.medium

import scala.collection.mutable

object Leet207CourseSchedule {
  def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {

    val (graph, indegreeArray) = buildGraph(prerequisites, numCourses)
    val queue = new mutable.Queue[Int]()
    indegreeArray.indices.filter(idx=>indegreeArray(idx) == 0).foreach(queue.addOne)
    var count = 0;
    while (queue.nonEmpty) {
      val top = queue.dequeue()
      count = count + 1
      val incomingEdges = graph.getOrElse(top, Array.empty)
      incomingEdges.foreach { edge =>
        indegreeArray.update(edge, indegreeArray(edge) - 1)
        if (indegreeArray(edge) == 0)
          queue.addOne(edge)
      }
    }
    count == numCourses
  }

  private def buildGraph(prerequisites: Array[Array[Int]], numCourses: Int) = {
    val indegree = Array.ofDim[Int](numCourses)
    val graph = prerequisites.map { pair =>
      indegree.update(pair(1), indegree(pair(1)) + 1)
      (pair(0), pair(1))
    }.groupBy(_._1).map(x => (x._1, x._2.map(_._2)))
    (graph, indegree)
  }
}
