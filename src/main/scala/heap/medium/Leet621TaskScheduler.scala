package heap.medium

import scala.collection.mutable

object Leet621TaskScheduler {
  def leastInterval(tasks: Array[Char], n: Int): Int = {
    val tasksLength = tasks.groupBy(identity).map(x =>  x._2.length)
    val pq = mutable.PriorityQueue[Int]()
    pq.addAll(tasksLength)
    completeTasks(n, pq, 0, 0)
  }

  private def completeTasks(coolingTime: Int,
                            pq: mutable.PriorityQueue[Int],
                            totalTimeTaken: Int,
                            lastLength: Int): Int = {
    if (pq.isEmpty) totalTimeTaken + lastLength - coolingTime - 1
    else {
      val tasksCanBeDone = (0 to coolingTime).flatMap { _ =>
        if (pq.nonEmpty) Some(pq.dequeue()) else None
      }
      val updatedTasks = tasksCanBeDone.filterNot(_ == 1).map(x => x - 1)
      pq.addAll(updatedTasks)
      completeTasks(coolingTime, pq, totalTimeTaken + coolingTime + 1, tasksCanBeDone.length)
    }
  }
}
