package slidingWindow.medium

class Leet1343NumberofSubarraysofSizeKandAverage {
  def numOfSubarrays(arr: Array[Int], k: Int, threshold: Int): Int = {
    val firstWindow=arr.take(k).sum
    val count=if((firstWindow)/k>=threshold)1 else 0
    arr.indices.drop(k).foldLeft(count,firstWindow){
      case((count, lastWindowSum),newIdx)=>
        val currentWindowSum=lastWindowSum+arr(newIdx)-arr(newIdx-k)
        val updatedCOunt=if((currentWindowSum)/k>=threshold)count+1 else count
        (updatedCOunt,currentWindowSum)
    }._1
  }
}
