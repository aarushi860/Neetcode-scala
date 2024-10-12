package graphs.medium

import scala.collection.mutable

//not working
object Leet2359FindClosestNodetoGivenTwoNodes {
  def closestMeetingNode(edges: Array[Int], node1: Int, node2: Int): Int = {
    val distance = Array.fill(edges.length)(0)
    val queue = new mutable.Queue[(Int, Int)]()
    queue.addOne((node1, 0))
    val node1Visited = mutable.Set[Int]()
    findDistance(edges, distance, queue, node1Visited)
    queue.addOne((node2, 0))
    val node2Visited = mutable.Set[Int]()
    findDistance(edges, distance, queue, node2Visited)
    val result = distance.zipWithIndex
      .filter(x => node1Visited.contains(x._2) && node2Visited.contains(x._2))
      .minByOption(_._1)
    result.map(_._2).getOrElse(-1)
  }


  private def findDistance(edges: Array[Int], distance: Array[Int],
                           queue: mutable.Queue[(Int, Int)],
                           visited: mutable.Set[Int]
                          ): Unit = {
    while (queue.nonEmpty) {
      val (top, steps) = queue.dequeue()
      visited.addOne(top)
      val outgoing = edges(top)
      if (outgoing != -1 && !visited.contains(outgoing)) {
        distance(outgoing) = Math.max(steps + 1, distance(outgoing))
        queue.addOne((outgoing, steps + 1))
      }
    }
  }
}
