package binarySearch.easy

object Leet374GuessNumberHigherorLower {
  trait GuessGame {
    def guess(num: Int): Int = {
      ???
    }
  }

  class Solution extends GuessGame {
    def guessNumber(n: Int): Int = {
      find(1, n, guess(n))
    }

    private def find(left: Int, right: Int, num: Int): Int = {
      if (left > right) -1
      else {
        val mid = left +( right-left) / 2
        mid match {
          case i if (mid == num) => i
          case i if (mid > num) => find(left, mid - 1, num)
          case _ => find(mid + 1, right, num)
        }
      }
    }
  }
}
