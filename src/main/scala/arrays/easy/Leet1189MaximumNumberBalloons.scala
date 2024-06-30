package arrays.easy

object Leet1189MaximumNumberBalloons extends App {

  println(maxNumberOfBalloons("nlaebolko"))

  def maxNumberOfBalloons(text: String) = {
    val map = text.groupMapReduce(x => x)(_ => 1)((a, b) => a + b)
    val keyMap = "balloon".groupMapReduce(x => x)(_ => 1)((a, b) => a + b)

    keyMap.foldLeft(text.length) { (min, x) =>
      val available = if (map.contains(x._1))
        map(x._1) / x._2
      else 0
      if (available < min) available else min
    }
  }

}
