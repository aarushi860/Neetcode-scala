package binarySearch.medium

object Leet2616MinimizetheMaximumDifferenceofPairs {

  def minimizeMax(nums: Array[Int], p: Int): Int = {
    val sorted = nums.sorted
    getMin(0, sorted.last - sorted.head, sorted, p)
  }

  private def getMin(left: Int, right: Int, nums: Array[Int], p: Int): Int = {
    if (left >= right) right
    else {
      val mid = (left + right) / 2
      val pairs = countPairs(mid, nums,1,0)
      if (pairs < p)
        getMin(mid + 1, right, nums, p)
      else getMin(left, mid, nums, p)
    }
  }

  private def countPairs(threshold: Int, nums: Array[Int],idx:Int,count:Int):Int = {
   if(idx>=nums.length)count
   else{
     if(Math.abs(nums(idx)-nums(idx-1))<=threshold)
       countPairs(threshold, nums, idx+2, count+1)
     else countPairs(threshold, nums, idx+1, count)
   }
  }
}
