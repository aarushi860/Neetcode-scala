package binarySearch.easy

object Leet367ValidPerfectSquare {
  def isPerfectSquare(num: Int): Boolean = {
    
    search(0, (num / 2) + 1, num)
  }

  private def search(left: Long, right: Long, num: Int): Boolean = {
    if (left > right) false
    else {
      val mid = (left + right) / 2
      val sq = mid * mid
      //   println(s"left : ${left} , right :${right} , mid : ${mid} , sq : ${sq}")
      sq match {
        case i if sq == num => true
        case i if sq < num => search(mid + 1, right, num)
        case _ => search(left, mid - 1, num)
      }
    }
  }
}
