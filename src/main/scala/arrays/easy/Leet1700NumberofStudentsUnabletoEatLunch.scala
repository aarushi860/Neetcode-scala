package arrays.easy

object Leet1700NumberofStudentsUnabletoEatLunch {
  def countStudents(students: Array[Int], sandwiches: Array[Int]): Int = {
    val map = students.groupBy(identity).view.mapValues(_.length).toMap
    val updatedMap = studentsDidNotEat(map, 0, sandwiches)
    updatedMap.values.sum
  }

  def studentsDidNotEat(map: Map[Int, Int], idx: Int, sanwiches: Array[Int]): Map[Int, Int] = {
    if (idx < sanwiches.length) {
      if (map.contains(sanwiches(idx))) {
        val studentCount = map(sanwiches(idx))
        val updatedMap = if (studentCount == 1)
          map.removed(sanwiches(idx))
        else map.updated(sanwiches(idx), studentCount - 1)
        studentsDidNotEat(updatedMap, idx + 1, sanwiches)
      } else map
    } else map
  }
}
