package arrays.medium

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object Leet451SortCharactersByFrequency {
  def frequencySort(s: String): String = {
    val sizes = s.groupBy(identity).values
    val max = sizes.maxBy(_.length).length
    val bucket: Array[String] = Array.ofDim(max + 1)
    sizes.foreach { size =>
      val str = bucket(size.length)
      val updated = if (str == null) size else str + size
      bucket.update(size.length, updated)
    }
    bucket.filterNot(_ == null).mkString.reverse
  }
  
}
