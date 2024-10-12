package graphs.medium

import scala.collection.mutable

object Leet2477MinimumFuelCosttoReporttotheCapital {
  def minimumFuelCost(roads: Array[Array[Int]], seats: Int): Long = {
    val queue = new mutable.Queue[Int]()
    val indegree = Array.ofDim[Int](roads.length + 1)
    val map = roads.flatMap { edge =>
      indegree.update(edge.head, indegree(edge.head) + 1)
      indegree.update(edge.last, indegree(edge.last) + 1)
      Array((edge.head, edge.last), (edge.last, edge.head))
    }.groupBy(_._1).map { case (k, v) => (k, v.map(_._2)) }

    indegree.indices.tail.foreach { idx =>
      if (indegree(idx) == 1) queue.addOne(idx)
    }
    val result = Array.fill(roads.length + 1)(1)
    var fuel = 0L
    while (queue.nonEmpty) {
      val node = queue.dequeue()
      //   println(s"node $node , fuel $fuel")
      fuel += Math.ceil(result(node).toDouble / seats).toLong

      if (map.contains(node)) {
        map(node).foreach { neighbor =>
          indegree.update(neighbor, indegree(neighbor) - 1)
          result(neighbor) += result(node)
          if (indegree(neighbor) == 1 && neighbor != 0)
            queue.addOne(neighbor)

        }
      }
    }
    fuel
  }


}
