package arrays.medium

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object Leet2610ConvertArrayInto2DArrayWithConditions {
  def findMatrix(nums: Array[Int]): List[List[Int]] = {
    val freq: Array[Int] = Array.ofDim(nums.length + 1)
    val result: ArrayBuffer[ArrayBuffer[Int]] = ArrayBuffer.empty
    nums.foreach { num =>
      if (freq(num) >= result.length) {
        result.addOne(new ArrayBuffer)
      }
      result(freq(num)).addOne(num)
      freq.update(num, freq(num) + 1)
    }
    result.map(_.toList).toList
  }
}
