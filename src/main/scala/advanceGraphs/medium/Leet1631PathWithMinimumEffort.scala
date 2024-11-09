package advanceGraphs.medium

import scala.collection.mutable

object Leet1631PathWithMinimumEffort {

  val DIRECTIONS = List((-1, 0), (0, -1), (1, 0), (0, 1))

  def minimumEffortPath(heights: Array[Array[Int]]): Int = {
    val m=heights.length
    val n= heights(0).length
    val differenceMatrix=Array.fill(m,n)(Integer.MAX_VALUE)
    val visitedMatrix=Array.fill(m,n)(false)
    val pq= new mutable.PriorityQueue[Cell]()(Ordering.by[Cell,Int](_.diff).reverse)
    differenceMatrix(0)(0)=0
    pq.addOne(Cell(0,0,0))
    while(pq.nonEmpty){
      val cell=pq.dequeue()
      visitedMatrix(cell.x)(cell.y)=true
      differenceMatrix(cell.x)(cell.y)=cell.diff
      if(cell.x==m-1 && cell.y==n-1)return cell.diff
      DIRECTIONS.foreach{direction=>
        val row=direction._1+cell.x
        val col=direction._2+cell.y
        if(heights.isDefinedAt(row) && heights(row).isDefinedAt(col) && !visitedMatrix(row)(col)){
          val currentDiff=Math.abs(heights(row)(col)-heights(cell.x)(cell.y))
          val maxDiff=Math.max(currentDiff,cell.diff)
          pq.addOne(Cell(row,col,maxDiff))
        }
      }
    }
    differenceMatrix(m-1)(n-1)
  }
case class Cell(x:Int,y:Int,diff:Int)

}
