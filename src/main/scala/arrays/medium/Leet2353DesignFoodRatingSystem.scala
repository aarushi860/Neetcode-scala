package arrays.medium

import scala.collection.mutable

object Leet2353DesignFoodRatingSystem {
  class FoodRatings(_foods: Array[String], _cuisines: Array[String], _ratings: Array[Int]) {

    implicit val foodOrdering: FoodOrdering.type = FoodOrdering
    private val foodDetailsMap: mutable.Map[String, (String, Int)] = mutable.Map.empty

    private val cuisineHighestRatings: mutable.Map[String, mutable.PriorityQueue[Food]] = mutable.Map.empty

    _foods.zipWithIndex.foreach { case (food, idx) =>
      val _food = Food(food, _ratings(idx))
      foodDetailsMap.put(food, (_cuisines(idx), _ratings(idx)))
      val pq: mutable.PriorityQueue[Food] = cuisineHighestRatings.getOrElse(_cuisines(idx), mutable.PriorityQueue.empty)
      pq.addOne(_food)
      cuisineHighestRatings.put(_cuisines(idx), pq)
    }
    println(cuisineHighestRatings)

    def changeRating(food: String, newRating: Int): Unit = {
      val (cuisine, _) = foodDetailsMap(food)
      foodDetailsMap.put(food, (cuisine, newRating))
      cuisineHighestRatings(cuisine).addOne(Food(food, newRating))
    }

    def highestRated(cuisine: String): String = {
      val map = cuisineHighestRatings(cuisine)
      var highestFood = map.head
      while (foodDetailsMap(highestFood.name)._2 != highestFood.ratings) {
        map.dequeue()
        highestFood = map.head
      }
      highestFood.name
    }

  }

  object FoodOrdering extends Ordering[Food] {
    override def compare(x: Food, y: Food): Int = if (x.ratings == y.ratings) y.name.compareTo(x.name)
    else (x.ratings - y.ratings)
  }

  case class Food(name: String, ratings: Int)
}

