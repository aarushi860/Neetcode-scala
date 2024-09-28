package linkedList.medium

import scala.collection.mutable

object Leet146LRUCache {
  class LRUCache(_capacity: Int) {

    val cache: mutable.Map[Int, Int] = mutable.Map.empty

    val linkedHashSet: mutable.LinkedHashSet[Int] = mutable.LinkedHashSet.empty
    val capacity = _capacity

    def get(key: Int): Int = {
      println(s"ON get $key , set is $linkedHashSet")
      if (cache.contains(key)) {
        updateBuffer(key)
        cache(key)
      } else -1
    }

    private def updateBuffer(key: Int) = {
      if (linkedHashSet.contains(key)) {
        linkedHashSet.remove(key)
        linkedHashSet.add(key)
      } else {
        if (linkedHashSet.size == capacity) {
          linkedHashSet.remove(linkedHashSet.head)
          cache.remove(key)
        }
        linkedHashSet.add(key)
      }
    }

    def put(key: Int, value: Int): Unit = {
      cache.update(key, value)
      updateBuffer(key)
    }

  }

}
