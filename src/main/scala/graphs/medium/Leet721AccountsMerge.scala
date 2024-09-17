package graphs.medium

import scala.collection.mutable

object Leet721AccountsMerge {
  def accountsMerge(accounts: List[List[String]]): List[List[String]] = {
    val n = accounts.length
    val rank = Array.fill(n)(1)
    val root = (0 until n).map(i => i).toArray

    def find(x: Int): Int = {
      if (x == root(x)) x
      else find(root(x))
    }

    def union(a: Int, b: Int) = {
      val root1 = find(a)
      val root2 = find(b)
      if (root1 != root2) {
        if (rank(root1) > rank(root2)) root(root2) = root1
        else if (rank(root2) > rank(root1)) root(root1) = root2
        else {
          rank(root1) = rank(root1) + 1
          root(root2) = root1
        }
      }
    }

    val emailAndAccountIdxMap: mutable.Map[String, Int] = mutable.Map.empty
    accounts.zipWithIndex.foreach { case (emails, accIdx) =>
      emails.foreach { email =>
        if (emailAndAccountIdxMap.contains(email)) union(accIdx, emailAndAccountIdxMap(email))
        else emailAndAccountIdxMap.put(email, accIdx)
      }
    }

    val result = emailAndAccountIdxMap.toList.map { case (email, accountIdx) =>
      val rootNode = find(accountIdx)
      (rootNode, email)
    }.groupBy(_._1).map(x => accounts(x._1).head +: x._2.map(_._2)).toList

    result
  }
}
