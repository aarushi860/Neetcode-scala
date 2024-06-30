package arrays

class Leet303RangeSumQueryImmutable(_nums: Array[Int]) {
  def sumRange(left: Int, right: Int): Int = {
    Range(left, right + 1).foldLeft(0)((sum, idx) => sum + _nums(idx))
  }

}

object Leet303RangeSumQueryImmutableImpl extends App {

  val ob=new Leet303RangeSumQueryImmutable(Array(-2,0,3,-5,2,-1))
println(ob.sumRange(0, 5))
}