package graphs.medium

object Leet684RedundantConnection {
  def findRedundantConnection(edges: Array[Array[Int]]): Array[Int] = {
    val n=edges.length
    val rank=Array.fill(n)(1)
    val root= (0 until  n).map(i=>i).toArray
    def findRoot(x:Int):Int={
      if(x==root(x))x
      else findRoot(root(x))
    }

    def isRedundant(edge:Array[Int])={
      val root1=findRoot(edge(0)-1)
      val root2=findRoot(edge(1)-1)
      if(root1==root2)true
      else{
        if(rank(root1)>rank(root2)) root(root2)=root1
        else if(rank(root2)>rank(root1))root(root1)=root2
        else{
          rank(root1)=rank(root1)+1
          root(root2)=root1
        }
        false
      }
    }
    edges.filter(isRedundant).last
  }
}
