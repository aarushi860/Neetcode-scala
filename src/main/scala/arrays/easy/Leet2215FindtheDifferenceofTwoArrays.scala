package arrays.easy

object Leet2215FindtheDifferenceofTwoArrays {
  def findDifference(nums1: Array[Int], nums2: Array[Int]): List[List[Int]] = {
    List(
      nums1.toSet.--(nums2).toList,
      nums2.toSet.--(nums1).toList
    )
  }
}
