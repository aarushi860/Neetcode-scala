package arrays.easy

object Leet1436DestinationCity extends App {

  def destCity(paths: List[List[String]]): String = {
    val graph = constructGraph(paths)
    paths.find(pair => !graph.contains(pair(1))).get(1)
  }

  def constructGraph(paths: List[List[String]]) = {
    paths.map(_(0)).toSet
  }

}
