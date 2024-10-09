//package slidingWindow.medium
//
//object Leet239SlidingWindowMaximum {
//  def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int] = {
//    val max = nums.take(k).max
//    val fq = nums.take(k).count(_ == max)
//    nums.zipWithIndex.drop(k).foldLeft(max, fq, 0, Array(max)) {
//      case ((max, fq, left, sliding), (num, idx)) =>
//        if (nums(left) == max)
//          ???
//    }
//
//  }
//}
