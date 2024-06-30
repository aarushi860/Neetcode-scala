package arrays.medium

import scala.annotation.tailrec
import scala.util.Random

object Leet347TopKFrequentElements extends App {

  def topKFrequent(nums: Array[Int], k: Int): Array[Int] = {
    val countMap = nums.groupMapReduce(x => x)(y => 1)((sum, count) => sum + count)
    val unique = countMap.keys.toArray
    val n = countMap.size
    quickSelect(0, n - 1, n - k, countMap, unique)
    println(unique.mkString)
    unique.takeRight(k)
  }

  @tailrec
  private def quickSelect(left: Int, right: Int, index: Int,
                          countMap: Map[Int, Int], unique: Array[Int]): Unit = {
    if (left != right) {
      val pivotIndex = Random.between(left, right)
      val updatedPivotIndex = partition(left, right, pivotIndex, countMap, unique)
      if (updatedPivotIndex > index)
        quickSelect(left, updatedPivotIndex - 1, index, countMap, unique)
      else if (updatedPivotIndex < index)
        quickSelect(updatedPivotIndex + 1, right, index, countMap, unique)
      else {

      }
    }
  }

  private def partition(left: Int, right: Int, pivotIndex: Int,
                        countMap: Map[Int, Int], unique: Array[Int]) = {
    val pivotFreq = countMap(unique(pivotIndex))
    swap(unique, right, pivotIndex)
    val updatedStoreIndex = getStoreIndex(left, unique, right, left, pivotFreq, countMap)
    swap(unique, updatedStoreIndex, right)
    updatedStoreIndex
  }

  @tailrec
  private def getStoreIndex(storeIdx: Int, unique: Array[Int],
                            right: Int,
                            idx: Int,
                            pivotFreq: Int, countMap: Map[Int, Int]): Int = {
    if (idx > right)
      storeIdx
    else {
      if (pivotFreq > countMap(unique(idx))) {
        swap(unique, storeIdx, idx)
        getStoreIndex(storeIdx + 1, unique, right, idx + 1, pivotFreq, countMap)
      } else getStoreIndex(storeIdx, unique, right, idx + 1, pivotFreq, countMap)
    }
  }


  private def swap(unique: Array[Int], idx1: Int, idx2: Int): Unit = {
    val temp = unique(idx1)
    unique.update(idx1, unique(idx2))
    unique.update(idx2, temp)
  }

}
