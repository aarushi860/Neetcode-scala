package binarySearch.medium

object Leet33SearchinRotatedSortedArray {
  def search(nums: Array[Int], target: Int): Int = {
    find(0, nums.length - 1, nums, target)
  }

  private def find(left: Int, right: Int, nums: Array[Int], target: Int): Int = {
    if (left > right) -1
    else {
      val mid = (left + right) / 2
      if (nums(mid) == target) mid
      else if(nums(mid)>=nums(left)){
        if(target>=nums(left) && target<nums(mid))
          find(left,mid-1,nums, target)
        else find(mid+1,right,nums,target)
      }else{
        if(target>nums(mid))
          find(mid+1,right, nums, target)
        else find(left, mid-1, nums, target)
      }
    }
  }
}
