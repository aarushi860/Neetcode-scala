package arrays.easy

object Leet1TwoSum extends App {

  println(twoSum(Array(3, 2, 4), 6).mkString("Array(", ", ", ")"))

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {

    val numsWithIdx = nums.zipWithIndex.toMap
    val idx1 = nums.indices.indexWhere { x =>
      val compliment = target - nums(x)
      numsWithIdx.get(compliment).exists(_ != x)
    }

    Array(idx1, numsWithIdx(target - nums(idx1)))
  }

}
