package slidingWindow.medium

object Leet904FruitIntoBaskets {
  def totalFruit(fruits: Array[Int]): Int = {
    val (_, _, left, max) = fruits.zipWithIndex.foldLeft((-1, -1, 0, 0)) {
      case ((basket1, basket2, left, max), (num, idx)) =>
        if (basket1 == -1) (num, basket2, left, max)
        else if (basket2 == -1 || (num == basket1 || num == basket2)) {
          val updatedMax = Math.max(idx - left + 1, max)
          (basket1, if (basket2 == -1 && num != basket1) num else basket2, left, updatedMax)
        } else {
          val updatedLeft = getNextStart(fruits(idx - 1), idx - 2, fruits)
          (fruits(idx - 1), fruits(idx), updatedLeft, max)
        }
    }
    Math.max(max, fruits.length - left)
  }

  private def getNextStart(prev: Int, idx: Int, fruits: Array[Int]): Int = {
    if (prev == fruits(idx)) {
      if (idx == 0) 0
      else getNextStart(prev, idx - 1, fruits)
    } else idx + 1
  }
}
