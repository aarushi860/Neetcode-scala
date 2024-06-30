package arrays

object Leet929UniqueEmailAddresses extends App {

   val result= numUniqueEmails(Array("test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"))
//  val result = numUniqueEmails(Array("a@leetcode.com", "b@leetcode.com", "c@leetcode.com"))
  println("Count is " + result)

  def numUniqueEmails(emails: Array[String]): Int = {
    accResult(0, Set.empty, emails)
  }

  def accResult(index: Int, acc: Set[String], emails: Array[String]): Int = {
    if (index < emails.length) {
      val updated = acc.+(processEmail(emails(index)))
      accResult(index + 1, updated, emails)
    } else acc.size
  }

  private def processEmail(s: String) = {
    val x = s.split('@')
    val localName = x(0)
    println("local name is " + localName)
    val domainName = x(1)
    val withoutDot = localName.replaceAll("\\.", "")
    val updated = withoutDot.split('+')(0)
    val result = updated + "@" + domainName
    println("string is " + s + " , after update " + result)
    result
  }

}

case class State1(index: Int, entries: Set[String])
