package trees.medium

import scala.collection.mutable

object Leet1443MinimumTimetoCollectAllApplesinTree {
  def minTime(n: Int, edges: Array[Array[Int]], hasApple: List[Boolean]): Int = {
    val adjMap=buildAdjacencyList(edges,mutable.Map.empty)
    dfs(0,-1,adjMap,hasApple)
  }

  private def dfs(node:Int, parent:Int, map:mutable.Map[Int,List[Int]],hasApple: List[Boolean]):Int={
    if(!map.contains(node))0
    else{
      map(node).filterNot(_==parent).map{child =>
        val childTime=dfs(child,node,map,hasApple)
        if(childTime>0||hasApple(child)){
           childTime+2
        }else 0
      }.sum
    }
  }

  private def buildAdjacencyList(edges:Array[Array[Int]],map:mutable.Map[Int,List[Int]]): mutable.Map[Int, List[Int]] ={
    edges.foreach{edge=>
      map.update(edge(0), map.getOrElse(edge(0),List()):+edge(1))
      map.update(edge(1), map.getOrElse(edge(1),List()):+edge(0))
    }
    map
  }
}
