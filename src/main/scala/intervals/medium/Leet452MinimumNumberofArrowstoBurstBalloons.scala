package intervals.medium

object Leet452MinimumNumberofArrowstoBurstBalloons {
  def findMinArrowShots(points: Array[Array[Int]]): Int = {
    implicit val ordering: Ordering[Array[Int]] = Ordering
      .by[Array[Int], Int](_.last)
    val sorted=points.sorted(ordering)
    sorted.tail.foldLeft(0,sorted.head.last){
      case ((count,prev),current)=>
        if(current.head>prev) (count+1,current.last)
        else (count,prev)
    }._1
  }
}
