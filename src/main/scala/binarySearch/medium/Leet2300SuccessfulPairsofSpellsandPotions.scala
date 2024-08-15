package binarySearch.medium

object Leet2300SuccessfulPairsofSpellsandPotions {
  def successfulPairs(spells: Array[Int], potions: Array[Int], success: Long): Array[Int] = {
    val sortedPOtions = potions.sorted
    spells.map { spell =>
      if (spell * sortedPOtions.last < success) 0
      else if(spell * sortedPOtions.head>=success) sortedPOtions.length
      else count(0, sortedPOtions.length - 1, sortedPOtions, spell, success)
    }
  }

  def count(left: Int, right: Int, potions: Array[Int], spell: Int, target: Long): Int = {
    if (left < right) {
      val mid = (left + right) / 2
      val product = potions(mid) * spell
      if (product >= target)
        count(left, mid, potions, spell, target)
      else count(mid + 1, right, potions, spell, target)
    } else potions.length - left - 1
  }
}
