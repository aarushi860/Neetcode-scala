package arrays.medium

import scala.collection.mutable

class UndergroundSystem() {

  val stationTimeTravelMap: mutable.Map[String, mutable.Map[String, Seq[Int]]] = mutable.Map.empty

  val userEnterMap: mutable.Map[Int, (String, Int)] = mutable.Map.empty

  def checkIn(id: Int, stationName: String, t: Int): Unit = {
    userEnterMap.put(id, (stationName, t))
  }

  def checkOut(id: Int, stationName: String, t: Int): Unit = {
    val (start, t1) = userEnterMap(id)
    val destinationMap: mutable.Map[String, Seq[Int]] = stationTimeTravelMap.getOrElse(start, mutable.Map.empty)
    destinationMap.put(stationName, destinationMap.getOrElse(stationName, Seq()) :+ t - t1)
    stationTimeTravelMap.put(start,destinationMap)
    userEnterMap.remove(id)
  }

  def getAverageTime(startStation: String, endStation: String): Double = {
    val seq = stationTimeTravelMap(startStation)(endStation)
    seq.sum.toDouble/seq.size.toDouble
  }

}