package linkedList.hard

import scala.collection.mutable

object Leet460LFUCache {
  class LFUCache(_capacity: Int) {

    val cache: mutable.Map[Int, (Int, Int)] = mutable.Map.empty
    val frequencies: mutable.Map[Int, mutable.LinkedHashSet[Int]] = mutable.Map.empty

    var min = 0

    def get(key: Int): Int = {
      if (cache.contains(key)) {
        val (value, fq) = cache(key)
        cleanUpCachesAndFrequencies(key, fq)
        putCachesAndFrequencies(key, value, fq + 1)
        cache(key)._1
      } else -1
    }

    def put(key: Int, value: Int): Unit = {
      if (!cache.contains(key) && cache.size == _capacity) {
        evictCache
        min = 1
      }
      val (_, fq) = cache.getOrElse(key, (-1, 0))
      cleanUpCachesAndFrequencies(key, fq)
      cache.put(key, (value, fq + 1))
      putCachesAndFrequencies(key, value, fq + 1)
    }

    private def evictCache = {
      val minFrequencyElements = frequencies(min)
      val keyToRemove = minFrequencyElements.head
      cache.remove(keyToRemove)
      if (minFrequencyElements.size == 1)
        frequencies.remove(min)
      else frequencies.update(min, minFrequencyElements.tail)
    }

    private def putCachesAndFrequencies(key: Int, value: Int, frequency: Int) = {
      cache.put(key, (value, frequency))
      val existingElements = frequencies.getOrElse(frequency, new mutable.LinkedHashSet[Int]())
      existingElements.add(key)
      frequencies.update(frequency, existingElements)
    }

    private def cleanUpCachesAndFrequencies(key: Int, frequency: Int) = {
      updateElementsForOldFqCount(key, frequency)
      cache.remove(key)
    }


    private def updateElementsForOldFqCount(key: Int, frequency: Int): Unit = {
      if (frequencies.get(frequency).nonEmpty) {
        val existingElements = frequencies(frequency)
        val updatedElements = existingElements.filterNot(_ == key)
        if (updatedElements.isEmpty) {
          frequencies.remove(frequency)
          if (frequency == min)
            min = min + 1
        } else if (frequency != 0) frequencies.update(frequency, updatedElements)
      }
    }
  }
}
