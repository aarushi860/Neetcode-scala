package binarySearch.medium

object Leet1011CapacityToShipPackages {

  def shipWithinDays(weights: Array[Int], days: Int): Int = {
    val max = weights.max
    val sum=weights.sum
    find(max,sum,weights, days)
  }

  private def find(left:Int,right:Int,weights:Array[Int],days:Int):Int={
    if(left>=right) right
      else{
      val mid=(left+right)/2
      if(feasible(mid,days,weights)){
        find(left,mid,weights, days)
      }else find(mid+1,right, weights, days)
    }
  }

  private def feasible(capacity:Int,days:Int,weights:Array[Int])={
    weights.foldLeft(0,0){
      case ((daysNeeded,sum),weight) =>
        if(sum+weight > capacity)
          (daysNeeded+1,weight)
        else (daysNeeded,sum+weight)
    }._1 <=days
  }


}
