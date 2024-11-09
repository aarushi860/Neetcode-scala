package advanceGraphs.medium

import scala.collection.mutable

object Leet787CheapestFlightsWithinKStops {
  def findCheapestPrice(n: Int, flights: Array[Array[Int]], src: Int, dst: Int, k: Int): Int = {
    val dist=Array.fill(n)(Integer.MAX_VALUE)
    dist(src)=0
    (0 to k).foldLeft(dist) {
      case (dist, _)=>
      val temp=Array.copyOf(dist,n)
      flights.foreach{flight=>
        if(dist(flight.head) != Integer.MAX_VALUE){
          temp(flight(1))=Math.min(temp(flight(1)), dist(flight.head)+flight.last)
        }
      }
     temp
    }
    if(dist(dst)==Integer.MAX_VALUE) -1 else dist(dst)
  }

}
