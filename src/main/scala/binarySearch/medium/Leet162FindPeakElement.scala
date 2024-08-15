package binarySearch.medium

object Leet162FindPeakElement {
  def findPeakElement(nums: Array[Int]): Int = {
    find(0, nums.length-1,nums)
  }

  private def find(left:Int, right:Int, nums:Array[Int]):Int={
    if(left==right)left
    else{
      val mid=(left+right)/2
      if(nums(mid)>nums(mid+1))
        find(left,mid-1,nums)
      else find(mid+1,right,nums)
    }
  }
}
