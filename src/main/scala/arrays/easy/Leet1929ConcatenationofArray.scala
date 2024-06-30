package arrays.easy

object Leet1929ConcatenationofArray extends App {
  println(getConcatenation(Array(1, 2, 3)).mkString("Array(", ", ", ")"))

  def getConcatenation(nums: Array[Int]): Array[Int] = {
    nums ++ nums
  }
}
