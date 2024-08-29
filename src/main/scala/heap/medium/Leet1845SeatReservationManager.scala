package heap.medium

import scala.collection.mutable

object Leet1845SeatReservationManager {
  class SeatManager(_n: Int) {

    private val availableSeats = mutable.PriorityQueue[Int]()(Ordering.Int).reverse
    (1 to _n).foreach(i => availableSeats.addOne(i))

    def reserve(): Int = {
      availableSeats.dequeue()
    }
    def unreserve(seatNumber: Int): Unit = {
      availableSeats.addOne(seatNumber)
    }
  }

}
