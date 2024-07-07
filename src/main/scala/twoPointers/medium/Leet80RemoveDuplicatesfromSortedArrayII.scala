//package twoPointers.medium
//
//object Leet80RemoveDuplicatesfromSortedArrayII {
//  def removeDuplicates(nums: Array[Int]): Int = {
//    if (nums.length <= 1)
//      nums.length
//    else {
//
//      nums.indices.tail.foldLeft((nums.head, 1, -1)) {
//
//        case ((lastNum, fq, lastIdx), newIdx) if lastNum == nums(newIdx) =>
//          if (fq <= 1)
//            (lastNum, fq + 1, lastIdx)
//          else {
//            if (lastIdx == -1) (lastNum, fq + 1, newIdx)
//            else (lastNum, fq + 1, lastIdx)
//          }
//        case ((lastNum, fq, lastIdx), newIdx) =>
//          if (lastIdx != -1) {
//            nums(lastIdx) = nums(newIdx)
//            (nums(newIdx), 1, newIdx + 1)
//          } else (nums(newIdx), 1, -1)
//
//      }._3 + 1
//    }
//  }
//}
