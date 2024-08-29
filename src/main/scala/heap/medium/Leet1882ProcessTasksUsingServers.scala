package heap.medium

import scala.collection.mutable

object Leet1882ProcessTasksUsingServers {
  def assignTasks(servers: Array[Int], tasks: Array[Int]): Array[Int] = {
    val serverPool = new mutable.PriorityQueue[Server]()(Ordering.by[Server, (Int, Int)](x => (x.weight, x.idx)).reverse)
    val serverProcessingTasks = new mutable.PriorityQueue[ServerTask]()(Ordering.by[ServerTask, Int](x => x.taskEndTime).reverse)
    servers.zipWithIndex.map { server => serverPool.addOne(Server(server._1, server._2)) }
    processTasks(serverPool, serverProcessingTasks, 0, 0, tasks, Array())

  }

  private def processTasks(serverPool: mutable.PriorityQueue[Server], serverProcessingTasks: mutable.PriorityQueue[ServerTask],
                           currTime: Int, currIdx: Int, tasks: Array[Int], result: Array[Int]
                          ): Array[Int] = {
    if (currIdx == tasks.length) result
    else {
      var updatedResult = result
      while (serverProcessingTasks.nonEmpty && serverProcessingTasks.head.taskEndTime <= currTime) {
        val serverTask = serverProcessingTasks.dequeue()
        println(s"At currTime ${currTime}, adding server ${serverTask.server} to pool")
        serverPool.addOne(serverTask.server)
      }
      var i = currIdx
      while (i <= currTime && i < tasks.length && serverPool.nonEmpty) {
        val server = serverPool.dequeue()
        println(s"At currTime ${currTime}, taking server ${server.idx} for task ${i}")
        serverProcessingTasks.addOne(ServerTask(i, i + tasks(i), server))
        updatedResult = updatedResult :+ server.idx
        i = i + 1
      }
      processTasks(serverPool, serverProcessingTasks, currTime + 1, i, tasks, updatedResult)
    }
  }


  case class Server(weight: Int, idx: Int)

  case class ServerTask(idx: Int, taskEndTime: Int, server: Server)
}
