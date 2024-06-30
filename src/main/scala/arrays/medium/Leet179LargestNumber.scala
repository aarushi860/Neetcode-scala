package arrays.medium

object Leet179LargestNumber {
  implicit val sorting: CustomOrder.type = CustomOrder

  def largestNumber(nums: Array[Int]): String = {
    val result = nums.map(_.toString).sorted.reverse
    if (result(0) == "0")
      return "0"
    else result.mkString
  }

  object CustomOrder extends Ordering[String] {
    override def compare(x: String, y: String): Int = (x + y).compareTo(y + x)
  }
}
