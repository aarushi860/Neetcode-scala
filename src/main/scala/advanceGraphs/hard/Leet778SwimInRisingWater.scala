package advanceGraphs.hard

import scala.collection.mutable

object Leet778SwimInRisingWater {

  val DIRECTIONS=List((-1,0),(0,-1),(0,1),(1,0))
  def swimInWater(grid: Array[Array[Int]]): Int = {
    val queue=new mutable.Queue[Cell]()
    val n=grid.length
    val visited= new mutable.HashSet[(Int,Int)]()
    while(queue.nonEmpty && queue.head.x != n-1 && queue.head.y != n-1){
      val cell=queue.dequeue()
      val currentTime=cell.time+1
      visited.add((cell.x,cell.y))
      val result=DIRECTIONS.flatMap {direction=>
        val row=direction._1+cell.x
        val col=direction._2+cell.y
        if(grid.isDefinedAt(row) && grid(row).isDefinedAt(col) && !visited.contains((row,col))) Some(row,col,grid(row)(col))
        else None
      }
      result.minByOption(_._3).foreach{a=>
        val newCell=Cell(a._1,a._2,currentTime,Math.max(a._3,currentTime))
        queue.addOne(newCell)
      }
    }
    queue.head.time
  }
case class Cell(x:Int,y:Int,time:Int,maximum:Int)
}

