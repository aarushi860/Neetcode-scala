package stack.medium

import scala.collection.mutable

object Leet71SimplifyPath {
  def simplifyPath(path: String): String = {
    val splits = path.split("/")
    val stack = new mutable.Stack[String]()

    splits.foreach {
      case ".." => if (stack.nonEmpty) stack.pop()
      case "" | "." => ()
      case value => stack.push(value)
    }

    "/" + stack.mkString("/")
  }
}
