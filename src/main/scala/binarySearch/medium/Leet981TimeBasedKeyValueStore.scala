package binarySearch.medium

import scala.collection.mutable

object Leet981TimeBasedKeyValueStore {
  class TimeMap() {
    val map = mutable.Map[String, mutable.TreeMap[Int,String]]()

    def set(key: String, value: String, timestamp: Int): Unit = {
      val existingQueue = map.getOrElse(key, mutable.TreeMap.empty[Int,String])
      existingQueue.update( timestamp,value)
      map.update(key,existingQueue)
    }

    def get(key: String, timestamp: Int): String = {
      if (map.contains(key)) {
        val existingQueue = map(key)
        existingQueue.rangeTo(timestamp).lastOption.map(_._2).getOrElse("")
      } else ""
    }
  }

}
