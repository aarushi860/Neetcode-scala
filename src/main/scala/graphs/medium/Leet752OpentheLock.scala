package graphs.medium

import scala.collection.mutable
import scala.util.control.Breaks.break

object Leet752OpentheLock {

  private val nextCharMap: mutable.Map[Char, Char]
  = mutable.Map('0' -> '1', '1' -> '2', '2' -> '3', '3' -> '4', '4' -> '5', '5' -> '6', '6' -> '7', '7' -> '8', '8' -> '9', '9' -> '0')

  private val prevCharMap: mutable.Map[Char, Char]
  = mutable.Map('1' -> '0', '2' -> '1', '3' -> '2', '4' -> '3', '5' -> '4', '6' -> '5', '7' -> '6', '8' -> '7', '9' -> '8', '0' -> '9')

  def openLock(deadends: Array[String], target: String): Int = {
    val set: mutable.Set[String] = mutable.Set.empty
    deadends.foreach(set.addOne)
    if (target == "0000" && !set.contains(target))
      0
    else if (set.contains(target) || set.contains("0000"))
      -1
    else {
      val queue = new mutable.Queue[(String, Int)]()
      queue.addOne(("0000", 0))
      set.add("0000")
      var found = -1;
      while (queue.nonEmpty && found == -1) {
        val top = queue.dequeue()
        (0 until 4).foreach { idx =>
          val previousStr = getPreviousString(top._1, idx)
          val nextStr = getNextString(top._1, idx)
          if (target == previousStr || target == nextStr) {
            found = top._2 + 1
          }
          adddToQueue(set, queue, top, previousStr)
          adddToQueue(set, queue, top, nextStr)
        }
      }
      found
    }
  }

  private def adddToQueue(set: mutable.Set[String], queue: mutable.Queue[(String, Int)], top: (String, Int), nextStr: String) = {
    if (!set.contains(nextStr)) {
      set.addOne(nextStr)
      queue.addOne((nextStr, top._2 + 1))
    }
  }

  private def getPreviousString(str: String, idx: Int) = {
    val previousChar = prevCharMap(str.charAt(idx))
    s"${str.substring(0, idx)}$previousChar${str.substring(idx + 1)}"
  }

  private def getNextString(str: String, idx: Int) = {
    val previousChar = nextCharMap(str.charAt(idx))
    s"${str.substring(0, idx)}$previousChar${str.substring(idx + 1)}"
  }

}
