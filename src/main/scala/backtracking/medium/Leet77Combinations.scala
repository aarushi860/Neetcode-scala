package backtracking.medium

object Leet77Combinations {
  def combine(n: Int, k: Int): List[List[Int]] = {
    val array:Array[Int]=(1 to n).map(i=>i).toArray
    combinations(array,k,Nil,0)
  }

  private def combinations(array:Array[Int],k:Int,acc:List[Int],i:Int):List[List[Int]]={
    if(acc.size == k)List(acc)
    else{
      array.indices.filter(_>=i).flatMap {idx=>
        val element=array(idx)
        combinations(array, k, acc:+element, idx+1)
      }.toList
    }
  }


}
