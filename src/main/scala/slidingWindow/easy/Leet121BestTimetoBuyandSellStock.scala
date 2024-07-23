package slidingWindow.easy

object Leet121BestTimetoBuyandSellStock {
  def maxProfit(prices: Array[Int]): Int = {
    prices.foldLeft(0,Integer.MAX_VALUE){
      case((max, min),price)=>
        val updatedMin=if(min<price)min else price
        val updatedMax =Math.max(max,price-min)
        (updatedMax,updatedMin)
    }._1
  }
}
