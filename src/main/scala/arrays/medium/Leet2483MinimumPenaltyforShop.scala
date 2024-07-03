package arrays.medium

object Leet2483MinimumPenaltyforShop {

  def bestClosingTime(customers: String): Int = {
    val totalY = customers.count(_ == 'Y')
    findMinPenalty(0, 0, 0, customers, totalY, Integer.MAX_VALUE, -1)
  }

  private def findMinPenalty(countN: Int, countY: Int,
                     idx: Int, customers: String,
                     totalY: Int,
                     minimumPenalty: Int, idxOfPenalty: Int): Int = {

    if (idx == customers.length) {
      if (countN < minimumPenalty)
        idx
      else idxOfPenalty
    }
    else {
      val ch = customers.charAt(idx)
      if (ch == 'Y') {
        val penalty = countN + totalY - countY
        if (penalty < minimumPenalty)
          findMinPenalty(countN, countY + 1, idx + 1, customers, totalY, penalty, idx)
        else findMinPenalty(countN, countY + 1, idx + 1, customers, totalY, minimumPenalty, idxOfPenalty)
      } else {
        val penalty = totalY - countY + countN
        if (penalty < minimumPenalty)
          findMinPenalty(countN + 1, countY, idx + 1, customers, totalY, penalty, idx)
        else findMinPenalty(countN + 1, countY, idx + 1, customers, totalY, minimumPenalty, idxOfPenalty)
      }
    }
  }
}
