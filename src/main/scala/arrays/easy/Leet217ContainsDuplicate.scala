package arrays

object Leet217ContainsDuplicate {
  def containsDuplicate(nums: Array[Int]) = {

    !Iterator.unfold(State(0, Set().empty, false)) {
      case State(_, _, true) => None
      case State(index, aggregator, finished) if index < nums.length =>
        if (aggregator.contains(nums(index))) Some(false, State(index + 1, aggregator, true))
        else Some(true, State(index + 1, aggregator + nums(index), finished))
      case State(_, _, _) => None
    }.reduceLeft(_ && _)
  }
}

case class State(index: Int, aggregator: Set[Int], result: Boolean)