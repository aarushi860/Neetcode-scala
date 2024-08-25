package trees.medium

object Leet1376TimeNeededtoInformAllEmployees {
  def numOfMinutes(n: Int, headID: Int, manager: Array[Int], informTime: Array[Int]): Int = {
    val reporteesMap = manager.zipWithIndex.groupBy(_._1).map(x => (x._1, x._2.map(_._2)))
    max(headID, reporteesMap, informTime)
  }

  private def max(headID: Int, reporteesMap: Map[Int, Array[Int]], informTime: Array[Int]): Int = {
    val timeFromRepoteesOpt = reporteesMap.get(headID)
    val maxTimeFromRepotees = if (timeFromRepoteesOpt.isDefined)
      timeFromRepoteesOpt.get.map(reportee => max(reportee, reporteesMap, informTime)).max
    else 0
    informTime(headID) + maxTimeFromRepotees
  }

}
