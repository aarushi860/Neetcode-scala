package slidingWindow.medium

object Leet424LongestRepeatingCharacterReplacement {
  def characterReplacement(s: String, k: Int): Int = {
    val fMap:Array[Int]=Array.ofDim(26)
    val start=s.indices.foldLeft(0,0){
      case((start,max),end) =>
        val chValue= s.charAt(end)-'A'
        fMap(chValue)=fMap(chValue)+1
        val updatedMax=Math.max(max,fMap(chValue))
        val isValid= end-start-updatedMax+1<=k
        if(!isValid){
          fMap(start)=fMap(start)-1
          (start+1,updatedMax)
        }else (start,updatedMax)
    }._1
    s.length-start
  }
}
