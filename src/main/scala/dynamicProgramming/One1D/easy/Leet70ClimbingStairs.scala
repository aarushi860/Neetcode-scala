package dynamicProgramming.One1D.easy

object Leet70ClimbingStairs {
  def climbStairs(n: Int): Int = {
    if(n<=2)n
    else climbStairs(n-1)+climbStairs(n-2)
  }
}
