package backtracking.medium

object Leet17LetterCombinationsofPhoneNumber {

  val mapping: Map[Int, Array[Char]] =Map(1->Array.empty,2->Array('a','b','c'),
    3-> Array('d','e','f'),4-> Array('g','h','i'),5-> Array('j','k','l'),
    6->Array('m','n','o'),7->Array('p','q','r','s'),8->Array('t','u','v'),
    9->Array('w','x','y','z')

  )
  def letterCombinations(digits: String): List[String] = {
    combinations(0,digits,"")
  }

  private def combinations(idx:Int,digits:String,acc:String):List[String]={
    if(idx==digits.length)List(acc)
    else{
      val values=mapping(digits.charAt(idx)-'0')
      values.flatMap {value=>
        combinations(idx+1,digits, acc:+value)
      }.toList
    }
  }
}
