package graphs.medium

import scala.collection.mutable

//not working
object Leet2101DetonatetheMaximumBombs {
  def maximumDetonation(bombs: Array[Array[Int]]): Int = {
    bombs.indices.map{idx=>
      val x=bombs(idx)(0)
      val y=bombs(idx)(1)
      val radius=bombs(idx)(2)
      val queue= new mutable.Queue[(Int,Int,Int)]()
      queue.addOne((x,y, radius))
      calculateNumberOfBombsInRange(bombs,queue)
    }.max
  }

  private def calculateNumberOfBombsInRange(bombs:Array[Array[Int]],
                                            queue:mutable.Queue[(Int,Int,Int)])={
    val visited=new mutable.HashSet[(Int,Int,Int)]()
    var count=0
    while(queue.nonEmpty){
      val (x,y,radius)=queue.dequeue()
      count+=1
      visited.addOne((x,y,radius))
      bombs.foreach{bomb=>
        if(!visited.contains((bomb(0),bomb(1),bomb(2)))){
          val distance = Math.sqrt(Math.pow(x - bomb(0), 2) + Math.pow(y - bomb(1), 2))
          if(distance <= radius) queue.addOne((x,y,bomb(2)))
        }
      }
    }
    count
  }
}
