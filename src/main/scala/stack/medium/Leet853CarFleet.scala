package stack.medium

import scala.collection.mutable

object Leet853CarFleet {
  def carFleet(target: Int, position: Array[Int], speed: Array[Int]): Int = {
    val positionWithSpeed = position.zip(speed).sortBy(_._1)
    positionWithSpeed.foldRight(Option.empty[Double],0) {
      case ((p, s), (lastTime,count)) =>
        val time = (target - p).toDouble / s.toDouble
        if (lastTime.isEmpty || lastTime.get < time)
          (Some(time),count+1)
        else (lastTime,count)
    }._2
  }
}
