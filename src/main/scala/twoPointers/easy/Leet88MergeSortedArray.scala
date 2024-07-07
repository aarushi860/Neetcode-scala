package twoPointers.easy

object Leet88MergeSortedArray {
  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
    (m-1 to 0 by -1).foreach { i =>
      nums1.update(i + n, nums1(i))
    }
    println(nums1.mkString(","))
    mergeArrays(n, 0, 0, nums1, nums2)
  }

  def mergeArrays(idx1: Int, idx2: Int, idx: Int, nums1: Array[Int], nums2: Array[Int]): Unit = {
    if (idx1 == nums1.length && idx2 == nums2.length) ()
    else if (idx1 == nums1.length ||(idx2<nums2.length && nums1(idx1) > nums2(idx2))) {
      nums1.update(idx, nums2(idx2))
      mergeArrays(idx1, idx2 + 1, idx + 1, nums1, nums2)
    }
    else {
      nums1.update(idx, nums1(idx1))
      mergeArrays(idx1 + 1, idx2, idx + 1, nums1, nums2)
    }
  }
}
