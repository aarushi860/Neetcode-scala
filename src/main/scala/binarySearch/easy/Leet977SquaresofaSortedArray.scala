package binarySearch.easy

object Leet977SquaresofaSortedArray {
  def sortedSquares(nums: Array[Int]): Array[Int] = {
    val output = Array.fill(nums.length)(0)
    sort(0, nums.length - 1,nums, output, nums.length - 1)
  }

  private def sort(left: Int, right: Int, nums:Array[Int],output: Array[Int], idx: Int): Array[Int] = {
    if (left > right || idx<0) {
      output
    } else {
      if (Math.abs(nums(left)) > Math.abs(nums(right))) {
        output.update(idx, nums(left) * nums(left))
        sort(left + 1, right, nums,output, idx - 1)
      } else {
        output.update(idx, nums(right) * nums(right))
        sort(left, right - 1, nums,output, idx-1)
      }
    }
  }
}
