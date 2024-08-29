package heap.hard

import scala.collection.mutable

object Leet1675MinimizeDeviationinArray {
  def minimumDeviation(nums: Array[Int]): Int = {
    val evens=nums.map(num=> if(num%2!=0)num*2 else num)
    val minimum=evens.min
    val pq=new mutable.PriorityQueue[Int]()
    pq.addAll(evens)
    getMinimum(minimum,pq.head-minimum,pq)
  }

  private def getMinimum(minimum:Int,deviation:Int, pq:mutable.PriorityQueue[Int]):Int={
    if(pq.head %2!=0)Math.max(pq.head-minimum,deviation)
    else{
      val top=pq.dequeue()/2
      pq.addOne(top)
      val updatedMinimum=Math.min(minimum,top)
      getMinimum(updatedMinimum,Math.max(deviation,pq.head-updatedMinimum),pq)
    }
  }
}
