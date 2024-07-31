package slidingWindow.medium

object Leet1208GetEqualSubstringsWithinBudget {
  def equalSubstring(s: String, t: String, maxCost: Int): Int = {
    val cost = s.zipWithIndex.map(x => getCost(x._1, t.charAt(x._2))).toArray
    cost.zipWithIndex.foldLeft(0, 0, 0) {
      case ((max, curr, left), (num, idx)) =>
        getMin(curr + num, left, maxCost, cost, idx, max)
    }._1
  }

  private def getMin(curr: Int, left: Int, target: Int, cost: Array[Int], right: Int, max: Int): (Int, Int, Int) = {
    if (curr > target && left < cost.length) {
      getMin(curr - cost(left), left + 1, target, cost, right, max)
    } else (Math.max(max, right - left + 1), curr, left)
  }

  private def getCost(ch1: Char, ch2: Char) = {
    val x= ch2-ch1
    Math.abs(x)
  }
}
