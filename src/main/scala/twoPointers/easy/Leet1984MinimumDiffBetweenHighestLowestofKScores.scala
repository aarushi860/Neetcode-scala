package twoPointers.easy

class Leet1984MinimumDiffBetweenHighestLowestofKScores {

  def minimumDifference(nums: Array[Int], k: Int): Int = {
    val sorted=nums.sorted
    getMin(0,sorted,k,Integer.MAX_VALUE)
  }

  private def getMin(start:Int, nums:Array[Int], k:Int, min:Int):Int={
    if(start+k-1==nums.length)
      min
      else{
      val updatedMin=Math.min(min, nums(start+k)-nums(start))
      getMin(start+1,nums,k,updatedMin)
    }
  }
}
