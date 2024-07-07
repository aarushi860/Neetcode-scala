package twoPointers.easy

object Leet344ReverseString {

  def reverseString(s: Array[Char]): Unit = {
    swapChars(0,s.length-1,s)
  }

  private def swapChars(left:Int,right:Int,s:Array[Char]):Unit={
    if(left<right){
      val temp=s(left)
      s.update(left,s(right))
      s.update(right,temp)
      swapChars(left+1,right-1,s)
    }
  }
}
