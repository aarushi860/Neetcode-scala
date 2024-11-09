//package graphs.medium
//
//import scala.collection.mutable
//
//object Leet310MinimumHeightTrees {
//  def findMinHeightTrees(n: Int, edges: Array[Array[Int]]): List[Int] = {
//    val graph = buildGraph(edges)
//    val leaves=graph.filter(_._2.size == 1).keys
//    val set=mutable.HashSet[Int]()
//    set.addAll(graph.keySet)
//    while(set.size==2){
//      leaves.foreach{leaf=>
//        val neighbors=graph(leaf)
//        neighbors.foreach{neighbor=>
//          graph.
//        }
//      }
//    }
//  }
//
//  private def buildGraph(edges: Array[Array[Int]]) = {
//    edges.flatMap { edge =>
//      List((edge.head, edge.last), (edge.last, edge.head))
//    }.groupBy(_._1).map(x => (x._1, x._2.map(_._2).toSet))
//  }
//}
