package arrays.easy

object Leet169MajorityElement {
  def majorityElement(nums: Array[Int]): Int = {
    nums.foldLeft((nums(0), 0)) { (acc, x) =>
      acc match {
        case (_, 0) => (x, 1)
        case (y, c) => if (x == y) (y, c + 1) else (y, c - 1)
      }
    }._1
  }
}
