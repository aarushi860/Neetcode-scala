package slidingWindow.medium

object Leet658FindKClosestElements {
  def findClosestElements(arr: Array[Int], k: Int, x: Int): List[Int] = {

    val minSum = getDistance(k,x,arr)
    val rightIdx = arr.zipWithIndex.drop(k).foldLeft(minSum, k - 1, minSum) {
      case ((min, rightMin, currSum), (num, idx)) =>
        val newSum = currSum + Math.abs(num-x) - Math.abs(arr(idx - k)-x)
        if (newSum < min) (newSum, idx, newSum)
        else (min, rightMin, newSum)
    }._2
    arr.slice(rightIdx - k + 1, rightIdx + 1).toList
  }

  private def getDistance(k:Int,x:Int,array: Array[Int])=
    array.take(k).map(y=>Math.abs(y-x)).sum
}
