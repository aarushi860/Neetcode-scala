package stack.medium

import scala.collection.mutable

object Leet2390RemovingStarsFromString {
  def removeStars(s: String): String = {
    s.foldLeft("") {
      case (result, ch) =>
        if (ch == '*')
          result.dropRight(1)
        else result :+ ch
    }
  }
}
