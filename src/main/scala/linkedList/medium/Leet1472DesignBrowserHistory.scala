package linkedList.medium

import linkedList.ListNode

object Leet1472DesignBrowserHistory {
  class BrowserHistory(_homepage: String) {

    val root= new HistoryNode(_homepage)
    var curr:HistoryNode=root
    def visit(url: String): Unit = {
      val node=new HistoryNode(url)
      val prevCurr=curr
      curr.next=node
      curr=node
      curr.prev=prevCurr
    }

    def back(steps: Int): String = {
      val updatedCurr=getBackSteps(steps,curr)
      curr=updatedCurr
      curr.x
    }

    private def getBackSteps(steps:Int, node:HistoryNode):HistoryNode={
      if(node==root || steps==0)node
      else getBackSteps(steps-1,node.prev)
    }

    private def getForwardSteps(steps:Int,node:HistoryNode):HistoryNode={
      if(steps==0|| node.next==null)node
      else getForwardSteps(steps-1,node.next)
    }

    def forward(steps: Int): String = {
      val updatedCurr=getForwardSteps(steps,curr)
      curr=updatedCurr
      curr.x
    }

  }

  class HistoryNode(_x: String) {
    var next: HistoryNode = null
    var prev:HistoryNode=null
    var x: String = _x
  }
}
