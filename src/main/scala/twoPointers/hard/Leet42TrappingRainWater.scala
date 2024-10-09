package twoPointers.hard

object Leet42TrappingRainWater {
  def trap(height: Array[Int]): Int = {

    def find(left: Int, right: Int, leftMax: Int, rightMax: Int, ans: Int): Int = {
      if (left >= right) ans
      else {
        if (height(left) < height(right)) {
          val updatedAns = ans + Math.max(leftMax - height(left), 0)
          val updatedLeftMax = Math.max(leftMax, height(left))
          find(left + 1, right, updatedLeftMax, rightMax, updatedAns)
        } else {
          val updatedAns = ans + Math.max(rightMax - height(right), 0)
          val updatedRightMax = Math.max(rightMax, height(right))
          find(left, right - 1, leftMax, updatedRightMax, updatedAns)
        }
      }
    }
    find(0, height.length - 1, 0, 0, 0)
  }
}
