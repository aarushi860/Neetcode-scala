package advanceGraphs.hard

import scala.collection.mutable

object Leet332ReconstructItinerary {
  def findItinerary(tickets: List[List[String]]): List[String] = {
    val graph=buildGraph(tickets)
    val result=mutable.ListBuffer[String]()
    var next="JFK"
    while(next!=null){
      result.addOne(next)
      val neighborsOpt=graph.get(next)
      if(neighborsOpt.isDefined && neighborsOpt.get.nonEmpty){
        next=neighborsOpt.get.head
        neighborsOpt.get.remove(next)
      }else next=null
    }
    result.toList
  }

  private def buildGraph(tickets:List[List[String]])={
    tickets.map{ticket=>
      (ticket.head,ticket.last)
    }.groupBy(_._1).map{case(k,v)=>
      val set=new mutable.TreeSet[String]()
      set.addAll(v.map(_._2))
      (k,set)
    }
  }
}
