package twoPointers.easy

object Leet455AssignCookies {
  def findContentChildren(g: Array[Int], s: Array[Int]): Int = {
    val sortedG = g.sorted
    val sortedS = s.sorted
    Iterator.unfold((0, 0)) {
      case (gIdx, sIdx) if sIdx == sortedS.length || gIdx == sortedG.length => None
      case (gIdx, sIdx) if sortedS(sIdx) >= sortedG(gIdx) =>
        Some(gIdx + 1, (gIdx + 1, sIdx + 1))
      case (gIdx, sIdx) if sortedS(sIdx) < sortedG(gIdx) =>
        Some(gIdx, (gIdx, sIdx + 1))
    }.toSeq.lastOption.getOrElse(0)
  }

}
