package heap.medium

import scala.collection.mutable

object Leet973KClosestPointstoOrigin {
  def kClosest(points: Array[Array[Int]], k: Int): Array[Array[Int]] = {
    implicit val ordering: Ordering[Point] = Ordering.by[Point, Int](point => point.distance).reverse
    val pq = new mutable.PriorityQueue[Point]()

    points.foreach { coordinate =>
      val distance = Math.pow(coordinate(0), 2) + Math.pow(coordinate(1), 2)
      val point = Point(coordinate, distance.toInt)
      pq.addOne(point)
    }

    (1 until k).map { _ =>
      val x = pq.dequeue().coordinates
      println(x.mkString(","))
      x
    }.toArray
  }

  case class Point(coordinates: Array[Int], distance: Int)

}