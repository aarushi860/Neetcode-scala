package trees.medium

object Leet96UniqueBinarySearchTrees {
  def numTrees(n: Int): Int = {
    val dp=Array.ofDim[Int](n+1)
    dp.update(0,1)
    dp.update(1,1)
    solve(dp,n)
    dp(n)
  }

  private def solve(dp:Array[Int],n:Int): Unit = {
    (2 to  n).foreach { idx=>
      val iResult = (1 to idx).map { j =>
        dp(j - 1) * dp(idx - j)
      }.sum

      dp.update(idx,iResult)
    }
  }
}
