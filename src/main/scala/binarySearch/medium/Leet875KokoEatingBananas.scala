package binarySearch.medium

object Leet875KokoEatingBananas {
  def minEatingSpeed(piles: Array[Int], h: Int): Int = {
    search(1, piles.max, piles, h)
  }

  private def search(left: Int, right: Int, piles: Array[Int], h: Int): Int = {
    if (left >= right) right
    else {
      val mid = left + (right - left) / 2
      val hoursNeeded = calculateHours(mid, piles)
      if (hoursNeeded > h)
        search(mid + 1, right, piles, h)
      else search(left, mid, piles, h)
    }
  }

  private def calculateHours(capacity: Int, piles: Array[Int]) = {
    piles.map { pile => Math.ceil(pile.toDouble / capacity.toDouble) }.sum.toInt
  }
}
