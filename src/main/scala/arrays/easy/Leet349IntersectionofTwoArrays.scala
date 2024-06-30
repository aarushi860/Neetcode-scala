package arrays.easy

object Leet349IntersectionofTwoArrays {

  def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val set = nums1.toSet
    nums2.toSet.intersect(set).toArray
  }
}
