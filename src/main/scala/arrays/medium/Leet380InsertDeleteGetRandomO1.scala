package arrays.medium

import scala.collection.mutable
import scala.util.Random

object Leet380InsertDeleteGetRandomO1 {


  class RandomizedSet() {

    val map: mutable.Map[Int, Int] = mutable.Map.empty
    val list: mutable.ArrayBuffer[Int] = mutable.ArrayBuffer.empty

    def insert(`val`: Int): Boolean = {
      if (map.contains(`val`))
        false
      else {
        list += `val`
        map.put(`val`, list.size - 1)
        true
      }
    }

    def remove(`val`: Int): Boolean = {
      if (map.contains(`val`)) {
        val lastElement = list.last
        val idx = map(`val`)
        list(idx) = lastElement
        map.put(lastElement, idx)
        list.remove(list.size - 1)
        map.remove(`val`)
        true
      } else false
    }

    def getRandom(): Int = {
      list(Random.nextInt(list.size))
    }
  }
}
