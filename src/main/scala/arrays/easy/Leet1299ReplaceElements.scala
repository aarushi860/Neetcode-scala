package arrays.easy

object Leet1299ReplaceElements extends App {

  println(replaceElements(Array(17, 18, 5, 4, 6, 1)).mkString("Array(", ", ", ")"))

  def replaceElements(arr: Array[Int]): Array[Int] = {
    arr.scanRight(-1)((max, next) => Math.max(max, next)).tail
  }

}
