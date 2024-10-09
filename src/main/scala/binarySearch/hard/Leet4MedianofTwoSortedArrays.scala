package binarySearch.hard

object Leet4MedianofTwoSortedArrays {
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    def findKthElement(start1: Int, end1: Int, start2: Int, end2: Int, k: Int): Int = {
      if (start1 > end1) nums2(k - start1)
      else if (start2 > end2) nums1(k - start2)
      else {
        val mid1 = (start1 + end1) / 2
        val mid2 = (start2 + end2) / 2
        if (mid1 + mid2 > k) {
          if (nums1(mid1) >= nums2(mid2))
            findKthElement(start1, mid1 - 1, start2, end2, k)
          else findKthElement(start1, end1, start2, mid2 - 1, k)
        } else {
          if (nums1(mid1) > nums2(mid2))
            findKthElement(start1, end1, mid2 + 1, end2, k)
          else findKthElement(mid1 + 1, end1, start2, end2, k)
        }
      }
    }

    val n = nums1.length + nums2.length
    if (n % 2 == 0) {
      val first = findKthElement(0, nums1.length - 1, 0, nums2.length, n / 2 - 1)
      val second = findKthElement(0, nums1.length - 1, 0, nums2.length, n / 2)
      (first + second) / 2.0
    } else findKthElement(0, nums1.length - 1, 0, nums2.length, n / 2)
  }
}
