package arrays.medium

import scala.collection.mutable.ListBuffer

object Leet1291SequentialDigits {
  def sequentialDigits(low: Int, high: Int): List[Int] = {
    val lowLen = low.toString.length
    val highLen = high.toString.length
    val str = "123456789"
    val result: ListBuffer[Int] = ListBuffer.empty
    for (len <- lowLen to highLen) {
      for (start <- 0 to 9 - len) {
        val num = str.substring(start, start + len).toInt
        if (num >= low && num <= highLen)
          result.addOne(num)
      }
    }
    result.toList
  }


}
