package advanceGraphs.hard

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution {
  def alienOrder(words: Array[String]): String = {
    val indegree = Array.fill(26)(-1)

    val notValid=words.indices.init.find { i =>
      val current = words(i)
      val next = words(i + 1)
      current.length>next.length && current.startsWith(next)
    }
    if(notValid.isDefined)return ""
    val graph = words.indices.init.flatMap { i =>
      val current = words(i)
        val next = words(i+1)
        getCombination(current, next, 0, indegree)
    }.groupBy(_._1).map { case (k, v) => (k, v.map(_._2)) }
    words.foreach { word =>
      word.foreach { ch =>
        indegree(ch - 'a') = graph.values.flatten.count(_==ch)
      }
    }

    println(s"graph $graph")
    println(s"indegree ${indegree.mkString(",")}")

    val queue = new mutable.Queue[Char]()
    indegree.indices.foreach{idx =>
      if (indegree(idx) == 0){
        val char =(idx+'a').toChar
        println(s"char is $char")
        queue.addOne(char)
      }
    }
    val result = new ListBuffer[Char]()
    while (queue.nonEmpty) {
      val qSize = queue.size
      (0 until qSize).foreach { _ =>
        val char = queue.dequeue()
        result.addOne(char)
        graph.get(char).foreach { neighbors =>
          neighbors.foreach { neighbor =>
            indegree(neighbor-'a') = indegree(neighbor-'a') - 1
            if (indegree(neighbor-'a') == 0)
              queue.addOne(neighbor)
          }
        }
      }
    }

    result.mkString

  }

  private def getCombination(current: String, next: String, idx: Int, indegree: Array[Int]): Option[(Char, Char)] = {
    if(idx==Math.min(current.length,next.length))None
    else if (current(idx) == next(idx)) getCombination(current, next, idx + 1, indegree)
    else {
      Some((current(idx), next(idx)))
    }
  }
}
