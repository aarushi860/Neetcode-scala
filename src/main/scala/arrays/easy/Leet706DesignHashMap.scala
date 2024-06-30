package arrays.easy

object Leet706DesignHashMap extends App {

  private val buckets: Array[Vector[(Int, Int)]] = Array.fill(1000)(Vector.empty)

  private def hash(key: Int) = key % buckets.length

  def put(key: Int, value: Int): Unit = {
    val bucket = hash(key)
    buckets(bucket) = (key, value) +: buckets(bucket)
  }

  def get(key: Int): Int = {
    val bucket = hash(key)
    buckets(bucket).find(_._1 == key).map(_._2).getOrElse(-1)
  }

  def remove(key: Int): Unit = {
    val bucket = hash(key)
    buckets(bucket) = buckets(bucket).filterNot(_._1 == key)
  }

}
