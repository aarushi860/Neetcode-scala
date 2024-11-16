package dynamicProgramming.One1D.medium

object Leet377CombinationSumIV {
  def combinationSum4(nums: Array[Int], target: Int): Int = {
    val memo=Array.fill(target+1)(-1)
    count(target, 0, nums,memo)
  }

  private def count(target: Int, sum: Int, nums: Array[Int],memo:Array[Int]): Int = {
    if (target == sum) 1
    else if (sum>target) 0
    else if(memo(sum)!= -1)memo(sum)
    else {
      memo(sum)=nums.indices.map { i =>
        val result = count(target, sum + nums(i), nums,memo)
        result
      }.sum
      memo(sum)
    }
  }
}
