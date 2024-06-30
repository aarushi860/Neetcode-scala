package arrays.easy

object Leet705DesignHashSet extends App {
  private val buckets: Array[List[Int]] = Array.fill(1000)(List.empty[Int])

  private def hash(key: Int) = key % buckets.length

  def add(key: Int): Unit = {
    val bucket = hash(key)
    if (!buckets(bucket).contains(key))
      buckets(bucket) = key :: buckets(bucket)
  }

  def remove(key: Int): Unit = {
    val bucket = hash(key)
    buckets(bucket) = buckets(bucket).filterNot(_ == key)
  }

  def _contains(key: Int): Boolean = {
    val bucket = hash(key)
    buckets(bucket).contains(key)
  }

}
