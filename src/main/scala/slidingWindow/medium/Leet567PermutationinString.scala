package slidingWindow.medium

object Leet567PermutationinString {
  def checkInclusion(s1: String, s2: String): Boolean = {
    if (s1.length > s2.length) false
    else {
      val s1Array: Array[Int] = Array.fill(26)(0)
      val s2Array = Array.fill(26)(0)
      s1.groupBy(identity).foreach(x => s1Array.update(x._1 - 'a', x._2.length))
      s2.substring(0, s1.length).groupBy(identity).foreach(x => s2Array.update(x._1 - 'a', x._2.length))
      val idx = (0 until s2.length - s1.length).indexWhere { i =>
        val result = areEqual(s1Array, s2Array)
        if (result) result
        else {
          val oldChIdx = s2.charAt(i) - 'a'
          val newChIdx = s2.charAt(i + s1.length) - 'a'
          s2Array.update(oldChIdx, s2Array(oldChIdx) - 1)
          s2Array.update(newChIdx, s2Array(newChIdx) + 1)
          false
        }
      }
      if (idx == -1 && !areEqual(s1Array,s2Array)) false else true
    }
  }

  private def areEqual(s1Array: Array[Int], s2Array: Array[Int]) = {
    s1Array.indices.forall { i =>
      s1Array(i) == s2Array(i)
    }
  }
}
