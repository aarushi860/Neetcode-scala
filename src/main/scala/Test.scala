import scala.collection.mutable

object Test extends App {

  val intervals = Map("a" -> List(10, 100), "b" -> List(50, 70), "c" -> List(60, 120), "d" -> List(150, 300))
  val pq = new mutable.PriorityQueue[Element]()(Ordering.by[Element, Int](_.start).reverse)
  intervals.foreach { interval =>
    pq.addOne(Element(interval._2.head, true, interval._1))
    pq.addOne(Element(interval._2.last, false, interval._1))
  }
  val set = mutable.Set[String]()
  var last: Option[Element] = None
  val result: mutable.ListBuffer[(List[String], Int, Int)] = mutable.ListBuffer.empty
  while (pq.nonEmpty) {
    val element = pq.dequeue()
    if (last.isDefined && element.start != last.get.start)
      result.addOne(set.toList, last.get.start, element.start)

    if (element.flag) set.add(element.name)
    else set.remove(element.name)
    last = Some(element)
  }
  println(result)
}

case class Element(start: Int, flag: Boolean, name: String)
