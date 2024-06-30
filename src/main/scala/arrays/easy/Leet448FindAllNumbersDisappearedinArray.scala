package arrays.easy;

object Leet448FindAllNumbersDisappearedinArray
  extends App {

  println(findDisappearedNumbers(Array(4, 3, 2, 7, 8, 2, 3, 1)))

  def findDisappearedNumbers(nums: Array[Int]): List[Int] = {
    nums.indices.foreach { idx =>
      val i = math.abs(nums(idx)) - 1
      if (i < nums.length && nums(i) > 0)
        nums(i) = -nums(i)
    }
    nums.zipWithIndex.collect {
      case (num, i) if num > 0 => i + 1
    }.toList

  }

}
