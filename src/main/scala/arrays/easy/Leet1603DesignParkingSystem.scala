package arrays.easy

import scala.collection.mutable

object Leet1603DesignParkingSystem {

  class ParkingSystem(_big: Int, _medium: Int, _small: Int) {

    val space: mutable.Map[Int, Int] = mutable.Map(1 -> _big, 2 -> _medium, 3 -> _small)

    def addCar(carType: Int): Boolean = {
      if (space(carType) >= 1) {
        space.put(carType, space(carType) - 1)
        true
      }
      else false
    }

  }
}
