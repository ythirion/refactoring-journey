package simplifying.method.calls

import java.util.UUID
import scala.util.Random

object Lottery {
  private val random: Random = new Random(42)
}

class Lottery {
  final private var tickets = Map.empty[UUID, LotteryTicket]

  def purchaseTicketForCustomer(id: UUID): String = {
    val ticketNumber: String = generateTicketNumber()
    tickets += (id -> LotteryTicket(ticketNumber, id))
    ticketNumber
  }

  private def generateTicketNumber(): String =
    String.format("%06d", Lottery.random.nextInt(1000000))

  def drawWinner(): Option[LotteryTicket] = {
    tickets.values match {
      case Nil => None
      case v   => Random.shuffle(v).headOption
    }
  }
}
