package arrays.easy

object Leet27RemoveElement extends App {
  println(removeElement(Array(0, 1, 2, 2, 3, 0, 4, 2), 2))

  def removeElement(nums: Array[Int], `val`: Int): Int = {
    nums.fold(0) {
      case (index, value) if (value != `val`) =>
        nums(index) = value
        index + 1
      case (index, value) =>
        index
    }
  }

}
