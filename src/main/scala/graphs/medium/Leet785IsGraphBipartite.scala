package graphs.medium

object Leet785IsGraphBipartite {

  def isBipartite(graph: Array[Array[Int]]): Boolean = {
    val n = graph.length
    val color = Array.ofDim[Int](n)

    def validate(node: Int, c: Int): Boolean = {
      if (color(node) != 0) color(node) == c
      else {
        color(node) = c
        graph(node).indices.forall(neighbor => validate(neighbor, -c))
      }
    }

    graph.indices.forall(i => color(i) != 0 || validate(i, 1))
  }
}
