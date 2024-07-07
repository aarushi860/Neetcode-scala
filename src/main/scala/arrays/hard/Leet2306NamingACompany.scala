package arrays.hard

import scala.collection.mutable

object Leet2306NamingACompany {

  def distinctNames(ideas: Array[String]): Long = {
    val array: Array[Set[String]] = Array.fill(26)(Set.empty)
    ideas.groupMapReduce(_.head)(y => Set(y.tail))((a, b) => a ++ b).foreach { x =>
      val idx: Int = x._1 - 'a'
      array.update(idx, x._2)
    }
    (0 until 26).flatMap { i =>
      (i + 1 until 26).map { j =>
        val matchingSuffix = array(i).intersect(array(j)).size
        val ans: Long = 2 * (array(i).size - matchingSuffix) * (array(j).size - matchingSuffix)
        ans
      }
    }.sum
  }

}
