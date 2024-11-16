package backtracking.medium

object Leet93RestoreIPAddresses {
  def restoreIpAddresses(s: String): List[String] = {
    construct(0, Nil, s).map { list =>
      list.mkString(".")
    }
  }

  def construct(idx: Int, acc: List[String], s: String): List[List[String]] = {
    if (idx == s.length) {
      if (acc.length == 4) List(acc) else Nil
    } else {
      s.indices.filter(_ >= idx).flatMap { i =>
        val str = s.substring(idx, i + 1)
        if (isValid(str)) construct(i + 1, acc:+str, s) else Nil
      }.toList
    }
  }

  private def isValid(s: String) = {
    s.length == 1 || (!s.startsWith("0") && s.length <= 3 && s.toInt <= 255)
  }
}
