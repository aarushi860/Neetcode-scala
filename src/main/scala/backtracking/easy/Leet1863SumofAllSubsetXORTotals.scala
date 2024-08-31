package backtracking.easy

//not working
object Leet1863SumofAllSubsetXORTotals {
  def subsetXORSum(nums: Array[Int]): Int = {
    getSum(0, nums, 0)
  }

  private def getSum(idx: Int, nums: Array[Int], sum: Int): Int = {
    if (idx == nums.length) sum
    else {
      val currIdxSum = nums.indices.filter(x => x >= idx).map(i=> calculateXOR(nums,idx,i)).sum
      getSum(idx + 1, nums, currIdxSum + sum)
    }
  }

  private def calculateXOR(nums: Array[Int], startIdx: Int, endIdx: Int): Int = {
    if(startIdx==endIdx)nums(startIdx)
    else nums.indices.filter(x => x >= startIdx && x <= endIdx).foldLeft(0)(_^nums(_))
  }
}
