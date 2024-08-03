package stack.medium

object Leet22GenerateParentheses {
  def generateParenthesis(n: Int): List[String] = {
    generateValidParenthesis(0,"",n).toList
  }

  def generateValidParenthesis(sum:Int,s:String,n:Int):Seq[String]= {
    if (s.length == n) {
      if(sum==0) Seq(s) else Seq()
    } else {
      if (sum == 0)
        generateValidParenthesis( 1, s + "(",n)
      else generateValidParenthesis(sum + 1, s + "(",n) ++ generateValidParenthesis(sum - 1, s + ")",n)
    }
  }
}
