package arrays.easy

object Leet1512NumberofGoodPairs extends App {

  def numIdenticalPairs(nums: Array[Int]): Int = {
    getCount(Map(), 0, nums, 0)
  }

  def getCount(map: Map[Int, Int], idx: Int, nums: Array[Int], count: Int): Int = {
    if (idx < nums.length) {
      val mapCount = map.getOrElse(nums(idx), 0)
      getCount(map.updated(nums(idx), mapCount + 1), idx + 1, nums, count + mapCount)
    } else count
  }

}
