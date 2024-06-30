package arrays.medium

class Leet122BestTimetoBuyandSellStockII extends App {
  def maxProfit(prices: Array[Int]): Int = {
    prices.foldLeft((0, Option.empty[Int])) {
      case ((profit, None), price) => (profit, Some(price))
      case ((profit, Some(prev)), price) if (price > prev) =>
        (profit + price - prev, Some(price))
      case ((profit, Some(prev)), price) =>
        (profit, Some(price))
    }._1
  }

}
