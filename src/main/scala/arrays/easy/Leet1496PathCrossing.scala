package arrays.easy

object Leet1496PathCrossing extends App {

  def isPathCrossing(path: String): Boolean = {
    path.foldLeft((Coordinate(0, 0), Set[Coordinate](Coordinate(0, 0)), false)) {
      case ((curr, set, true), _) => (curr, set, true)
      case ((curr, set, _), next) => {
        val newCoordinate = evaluateDirection(next, curr)
        (newCoordinate, set.+(newCoordinate), set.contains(newCoordinate))
      }
    }._3
  }

  def evaluateDirection(ch: Char, current: Coordinate) = {
    ch match {
      case 'N' => Coordinate(current.x + 1, current.y)
      case 'S' => Coordinate(current.x - 1, current.y)
      case 'E' => Coordinate(current.x, current.y + 1)
      case 'W' => Coordinate(current.x, current.y - 1)
    }
  }

}

case class Coordinate(x: Int, y: Int)
