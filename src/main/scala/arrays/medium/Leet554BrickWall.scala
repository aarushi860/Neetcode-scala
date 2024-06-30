package arrays.medium

object Leet554BrickWall extends App {
  def leastBricks(wall: List[List[Int]]): Int = {

    val positions = wall.map { eachWall =>
      eachWall.scanLeft(0)((sum, num) => sum + num).tail.take(eachWall.length-1)
    }

    val map = positions.flatten.groupMapReduce(x => x)(y => 1)((sum, count) => sum + count)
    println(map)
    if(map.values.isEmpty)0
    else wall.length - map.values.max
  }

  println(leastBricks(List(List(1,2,2,1),List(3,1,2),List(1,3,2),List(2,4),List(3,1,2),List(1,3,1,1))))
}
