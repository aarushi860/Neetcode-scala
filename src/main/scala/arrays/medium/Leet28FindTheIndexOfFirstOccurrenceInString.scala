//package arrays.medium
//
//object Leet28FindTheIndexOfFirstOccurrenceInString {
//  def strStr(haystack: String, needle: String): Int = {
//    val n = needle.length
//    haystack.zipWithIndex.find { case (ch, idx) =>
//      if (needle(0) == ch && idx < haystack.length - n)
//        haystack.substring(idx, idx + n) == needle
//      else false
//    }.map(_._2).getOrElse(-1)
//  }
//
//
//}
