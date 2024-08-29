package heap.medium

import scala.collection.mutable

object Leet1834SingleThreadedCPU {
  def getOrder(tasks: Array[Array[Int]]): Array[Int] = {
    val taskPool= new mutable.PriorityQueue[Task]()(Ordering.by[Task,Int](x=> x.startTime).reverse)
    val taskAvailableAtCurrTime=new mutable.PriorityQueue[Task]()(Ordering.by[Task,(Int,Int)](x=> (x.processingTime,x.idx)).reverse)
    val allTasks=tasks.zipWithIndex.map{time=>
      Task(time._1(1),time._2,time._1(0))
    }

    taskPool.addAll(allTasks)
    val currentTime=taskPool.head.startTime
    processTasks(Array(),currentTime,taskPool,taskAvailableAtCurrTime)
  }

  private def processTasks(result:Array[Int],currTime:Int,
                           taskPool:mutable.PriorityQueue[Task],taskAvailable:mutable.PriorityQueue[Task]):Array[Int]={
    if(taskPool.isEmpty && taskAvailable.isEmpty)result
    else{
      while(taskPool.nonEmpty && taskPool.head.startTime<=currTime){
        taskAvailable.addOne(taskPool.dequeue())
      }
      if(taskAvailable.nonEmpty){
        val taskToProcess=taskAvailable.dequeue()
        processTasks(result:+taskToProcess.idx,currTime+taskToProcess.processingTime,taskPool,taskAvailable)
      } else processTasks(result,taskPool.head.startTime,taskPool,taskAvailable)
    }
  }
  case class Task(processingTime:Int, idx:Int, startTime:Int)
}
