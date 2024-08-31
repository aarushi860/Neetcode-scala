package heap.medium

import scala.collection.mutable

object Leet1094CarPooling {
  def carPooling(trips: Array[Array[Int]], capacity: Int): Boolean = {
    val pq = new mutable.PriorityQueue[Trip]()(CustomOrdering)
    isPossible(capacity, pq, trips.sortBy(x=>x(2)), 0)
  }

  private def isPossible(availability: Int, pq: mutable.PriorityQueue[Trip], trips: Array[Array[Int]], idx: Int): Boolean = {
    if (idx == trips.length) true
    else {
      val trip = Trip(trips(idx)(0), trips(idx)(1), trips(idx)(2))
      var emptySeats = 0
      println(s"PQ head ${pq.headOption}")
      while (pq.nonEmpty && pq.head.endKm <= trip.startKm) {
        emptySeats = emptySeats + pq.dequeue().passengers
      }
      val totalAvailability = availability + emptySeats
      if (totalAvailability < trip.passengers) false
      else {
        pq.addOne(trip)
        isPossible(availability - trip.passengers, pq, trips, idx + 1)
      }
    }
  }

  object CustomOrdering extends Ordering[Trip] {
    override def compare(x: Trip, y: Trip): Int = {
      if (x.endKm == y.endKm) y.passengers - x.passengers
      else x.endKm - y.endKm
    }
  }

  case class Trip(passengers: Int, startKm: Int, endKm: Int)

}
