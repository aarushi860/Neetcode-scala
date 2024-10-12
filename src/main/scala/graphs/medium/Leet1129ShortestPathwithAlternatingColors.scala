package graphs.medium

import scala.collection.mutable

object Leet1129ShortestPathwithAlternatingColors {
  def shortestAlternatingPaths(n: Int, redEdges: Array[Array[Int]],
                               blueEdges: Array[Array[Int]]): Array[Int] = {
    val queue = new mutable.Queue[(Int, Int, Int)]()
    queue.addOne((0, 0, -1))
    val result = Array.fill(n)(-1)
    val tuples = redEdges.map { edge => (edge.head, edge.last, 0) } ++
      blueEdges.map { edge => (edge.head, edge.last, 1) }
    val map = tuples.groupBy(_._1).map { case (k, v) => (k, v.map(x => (x._2, x._3))) }
    val visited = new mutable.HashSet[(Int, Int)]()
    visited.addOne((0, 0))
    visited.addOne((0, 1))
    while (queue.nonEmpty) {
      val node = queue.dequeue()
      if (result(node._1) == -1) result.update(node._1, node._2)
      if (map.contains(node._1)) {
        map(node._1).foreach { neighbor =>
          if (neighbor._2 != node._3 && !visited.contains(neighbor)) {
            visited.addOne(neighbor)
            queue.addOne((neighbor._1, node._2 + 1, neighbor._2))
          }
        }
      }
    }
    result
  }
}
