package arrays.medium

object Leet280WiggleSort {

  def wiggleSort(nums: Array[Int]): Unit = {
    nums.zipWithIndex.map{
      case(element, idx)=>
        if(idx!=nums.length-1){
          if((idx%2==0 && nums(idx)>nums(idx+1))||(idx%2==1 && nums(idx)<nums(idx+1)))
            swap(nums,idx,idx+1)
        }
        (element,idx)
    }
  }

  private def swap(nums:Array[Int],i:Int,j:Int)={
    val temp=nums(i)
    nums.update(i,nums(j))
    nums.update(j,temp)
  }
}
