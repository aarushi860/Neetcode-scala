package binarySearch.medium

//not working
object Leet1898MaximumNumberofRemovableCharacters {
  def maximumRemovals(s: String, p: String, removable: Array[Int]): Int = {
    findOPtimal(s, p, removable, 0, removable.length - 1)
  }

  private def findOPtimal(s: String, p: String, removable: Array[Int], left: Int, right: Int): Int = {
    if (left > right) right
    else {
      val mid = (left + right) / 2
      val idxToConsider = removable.take(mid)
      val updatedString = s.zipWithIndex.filter(x => !idxToConsider.contains(x._2))
      if (updatedString.map(_._1).mkString.contains(p))
        findOPtimal(s, p, removable, mid, right)
      else findOPtimal(s, p, removable, left, mid - 1)
    }
  }
}
