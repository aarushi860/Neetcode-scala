package advanceGraphs.medium

import scala.collection.mutable

object Leet743NetworkDelayTime  {
  def networkDelayTime(times: Array[Array[Int]], n: Int, k: Int): Int = {
    val distance=Array.fill(n)(-1)
    distance(k)=0
    val graph=buildGraph(times)
    val queue= new mutable.Queue[Edge]()
    queue.addOne(Edge(k,0))
    while(queue.nonEmpty){
      val edge=queue.dequeue()
      val currentDistance=edge.time
      graph.get(edge.to).foreach{neighbors=>
        neighbors.foreach{neighbor=>
          if(distance(neighbor._1) == -1 || currentDistance+neighbor._2<distance(neighbor._1)){
            distance(neighbor._1)=currentDistance+neighbor._2
            queue.addOne(Edge(neighbor._1,distance(neighbor._1)))
          }
        }
      }
    }
    if(distance.contains(-1))-1 else distance.max
  }
  private def buildGraph(times:Array[Array[Int]])={
    times.map{time=>
      (time(0),time(1),time(2))
    }.groupBy(_._1).map{case(k,v)=>(k,v.map(x=>(x._2,x._3)))}
  }
  case class Edge(to:Int,time:Int)
}
