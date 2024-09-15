package graphs.medium

import scala.collection.mutable

object Leet1462CourseScheduleIV {
  def checkIfPrerequisite(numCourses: Int, prerequisites: Array[Array[Int]], queries: Array[Array[Int]]): List[Boolean] = {

    val graph = buildGraph(prerequisites)
    val map = mutable.Map.empty[Int, Set[Int]]
    (0 until numCourses).foreach { i =>
      val set = mutable.Set.empty[Int]
      dfs(i, Array.ofDim[Boolean](numCourses), set, graph, map)
      map.put(i, map.getOrElse(i, Set.empty[Int]) ++ set)
    }
    queries.map { query =>
      map.contains(query(0)) && map(query(0)).contains(query(1))
    }.toList

  }

  private def dfs(i: Int, visited: Array[Boolean],
                  allEments: mutable.Set[Int],
                  graph: Map[Int, Array[Int]],
                  map: mutable.Map[Int, Set[Int]]
                 ): Unit = {
    visited(i) = true
    val incoming = graph.getOrElse(i, Array.empty[Int])
    incoming.foreach { edge =>
      allEments.add(edge)
      if(!visited(i)) {
        if (map.contains(edge))
          allEments.addAll(map(edge))
        else {
          allEments.add(edge)
          dfs(edge, visited, allEments, graph, map)
        }
      }
    }
  }

  private def buildGraph(prerequisites: Array[Array[Int]]) = {
    prerequisites.map { pair =>
      (pair(0), pair(1))
    }.groupBy(_._1).map(x => (x._1, x._2.map(_._2)))
  }
}
