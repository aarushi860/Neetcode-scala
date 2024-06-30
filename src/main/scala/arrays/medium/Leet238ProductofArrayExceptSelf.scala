package arrays.medium

object Leet238ProductofArrayExceptSelf extends App{
  productExceptSelf(Array(1,2,3,4))
  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    val right = nums.scanRight(1)((a, b) => a * b)
    println(right.mkString(","))
    val left = nums.scanLeft(1)((a, b) => a * b)
    println(left.mkString(","))
    nums.indices.map(idx => left(idx) * right(idx + 1)).toArray
  }

}
