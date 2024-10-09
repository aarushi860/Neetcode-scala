package binarySearch.hard

object Leet1095FindInMountainArray {
  def findInMountainArray(value: Int, mountainArr: MountainArray): Int = {
    val peekIdx = findPeek(0, mountainArr.length() - 1, mountainArr)
    val left = findInLeftSide(0, peekIdx, mountainArr, value)
    if (left != -1) left
    else findInRightSide(peekIdx + 1, mountainArr.length() - 1, mountainArr, value)
  }

  private def findPeek(left: Int, right: Int, mountainArray: MountainArray): Int = {
    if (left == right) right
    else {
      val mid = (left + right) / 2
      if (mountainArray.get(mid) > mountainArray.get(mid + 1))
        findPeek(left, mid , mountainArray)
      else findPeek(mid + 1, right, mountainArray)
    }
  }

  private def findInLeftSide(left: Int, right: Int, mountainArray: MountainArray, value: Int): Int = {
    if (left > right) -1
    else {
      val mid = (left + right) / 2
      val midValue = mountainArray.get(mid)
      if (value == midValue)
        mid
      else if (value > midValue)
        findInLeftSide(mid + 1, right, mountainArray, value)
      else findInLeftSide(left, mid - 1, mountainArray, value)
    }
  }

  private def findInRightSide(left: Int, right: Int, mountainArray: MountainArray, value: Int): Int = {
    if (left > right) -1
    else {
      val mid = (left + right) / 2
      val midValue = mountainArray.get(mid)
      if (value == midValue)
        mid
      else if (value > midValue)
        findInLeftSide(left, mid - 1, mountainArray, value)
      else findInLeftSide(mid + 1, right, mountainArray, value)
    }
  }


  class MountainArray {
    def get(index: Int): Int = ???

    def length(): Int = ???

  }
}
