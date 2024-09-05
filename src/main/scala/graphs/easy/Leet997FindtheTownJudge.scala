package graphs.easy

object Leet997FindtheTownJudge {
  def findJudge(n: Int, trust: Array[Array[Int]]): Int = {

    val trustees = Array.fill[Int](n + 1)(0)
    val potentialJudge = Array.fill[Int](n + 1)(0)

    for (Array(currentTrustee, currentPotentialJudge) <- trust) {
      trustees(currentTrustee) += 1
      potentialJudge(currentPotentialJudge) += 1
    }

    trustees.indices.find { trusteeIdx =>
      trusteeIdx!=0 && trustees(trusteeIdx) == 0 && potentialJudge(trusteeIdx) == n - 1
    }.getOrElse(-1)

  }
}
