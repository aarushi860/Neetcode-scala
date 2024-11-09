package trees.medium

import scala.collection.mutable

object Leet1993OperationsonTree {
  class LockingTree(_parent: Array[Int]) {

    val parentMap = _parent.indices.map { idx =>
      (idx, _parent(idx))
    }.toMap

    val childrenMap = _parent.zipWithIndex.groupBy(_._2).map(x => (x._1, x._2.map(_._1)))

    val locked: mutable.Map[Int, Int] = mutable.Map.empty

    def lock(num: Int, user: Int): Boolean = {
      if (locked.contains(num)) false
      else {
        locked.put(num, user)
        true
      }
    }

    def unlock(num: Int, user: Int): Boolean = {
      if (locked.contains(num) && locked(num) == user) {
        locked.remove(num)
        true
      } else false
    }

    def upgrade(num: Int, user: Int): Boolean = {
      if (locked.contains(num)) false
      else {
        if (anyChildLocked(num) && noParentLocked(num)) {
          unlockAllChildren(num)
          locked.put(num, user)
          true
        } else false
      }
    }

    private def anyChildLocked(num: Int): Boolean = {
      if (childrenMap.contains(num)) {
        if (childrenMap(num).exists(locked.contains)) true else childrenMap(num).exists(anyChildLocked)
      } else false
    }

    private def noParentLocked(num: Int): Boolean = {
      if (parentMap.contains(num) && parentMap(num) != -1) {
        if (locked.contains(parentMap(num))) false else noParentLocked(parentMap(num))
      } else true
    }

    private def unlockAllChildren(num: Int): Unit = {
      childrenMap.get(num).foreach { children =>
        children.foreach { child =>
          locked.remove(child)
          unlockAllChildren(child)
        }
      }
    }
  }
}
