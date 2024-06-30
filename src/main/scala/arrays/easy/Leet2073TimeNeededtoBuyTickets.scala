package arrays.easy

object Leet2073TimeNeededtoBuyTickets {

  def timeRequiredToBuy(tickets: Array[Int], k: Int): Int = {
    tickets.foldLeft((0,0)){
      case((time,idx),ticket)if(idx<=k)=>(time+math.min(ticket,tickets(k)),idx+1)
      case((time,idx),ticket)=>(time+math.min(ticket,tickets(k)-1),idx+1)
    }._1
  }

}
