package advanceGraphs.hard

object Leet1579RemoveMaxNumberofEdges {
  def maxNumEdgesToRemove(n: Int, edges: Array[Array[Int]]): Int = {
    val aGraph= new UnionFind(n)
    val bGraph= new UnionFind(n)
    val type3Edges=edges.filter(_.head==3)
    val edgeNotRequiredFromtype3=type3Edges.map{edge=>
      if(aGraph.connected(edge(1),edge(2)) && bGraph.connected(edge(1),edge(2)))1
      else{
        aGraph.union(edge(1),edge(2))
        bGraph.union(edge(1),edge(2))
        0
      }
    }.sum
    val otherTypesEdges=edges.filterNot(_.head==3)
    val edgeNotRequiredFromOtherTYpes = otherTypesEdges.map { edge =>
      if (edge.head==1) {
        if(aGraph.connected(edge(1), edge(2)))1
        else {aGraph.union(edge(1), edge(2))
          0
        }
      }else if (edge.head==2) {
        if(bGraph.connected(edge(1), edge(2)))1
        else{
          bGraph.union(edge(1), edge(2))
          0
        }
      }else 0
    }.sum
    val isAGraphConnected=(1 to n ).groupBy(x=>aGraph.find(x-1)).size==1
    val isBGraphConnected=(1 to n ).groupBy(x=>bGraph.find(x-1)).size==1
    if(isAGraphConnected && isBGraphConnected) edgeNotRequiredFromtype3+edgeNotRequiredFromOtherTYpes
    else -1
  }

  class UnionFind(n:Int){
    val rank=Array.fill(n)(1)
    val root=Array.ofDim[Int](n)
    root.indices.foreach(idx=> root(idx)=idx)
    def find(x:Int):Int={
      if(x==root(x))x
      else find(root(x))
    }

    def union(x: Int, y: Int) = {
      val rootX = find(x-1)
      val rootY = find(y-1)
      if (rootX != rootY) {
        if (rank(rootX) > rank(rootY)) root(rootY) = rootX
        else if (rank(rootX) < rank(rootY)) root(rootX) = rootY
        else {
          root(rootY) = rootX
          rank(rootX) += 1
        }
      }
    }

    def connected(x:Int,y:Int)={
      find(x-1)==find(y-1)
    }
  }
}
