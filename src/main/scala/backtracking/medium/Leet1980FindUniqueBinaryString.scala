package backtracking.medium

object Leet1980FindUniqueBinaryString {
  def findDifferentBinaryString(nums: Array[String]): String = {
    val allPossible=getAllBinnaryStrings(0,nums.length)
    val set=nums.toSet
    allPossible.find(x=> !set.contains(x)).getOrElse("")
  }

  private def getAllBinnaryStrings(idx:Int,n:Int):Set[String]={
    if(idx==n-1)Set("0","1")
    else {
      val acc: Set[String] =getAllBinnaryStrings(idx+1,n)
      acc.flatMap {x=>
       Set('0'+:x , '1'+:x)
      }
    }
  }
}
