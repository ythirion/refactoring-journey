package simplifying.method.calls

import java.util.UUID
import scala.collection.mutable
import scala.util.Random

object Lottery {
  private val random: Random = new Random(42)
}

class Lottery {
  final private val tickets = mutable.Map.empty[UUID, LotteryTicket]

  def purchaseTicketForCustomer(id: UUID, name: String): String = {
    val ticketNumber: String = generateTicketNumber("")
    tickets(id) = LotteryTicket(ticketNumber, id)
    ticketNumber
  }

  def drawWinner(
      ticketPrice: Double,
      prizeAmount: Double
  ): Option[LotteryTicket] = {
    tickets.values match {
      case Nil => None
      case v   => Random.shuffle(v).headOption
    }
  }

  private def generateTicketNumber(format: String): String =
    String.format("%06d", Lottery.random.nextInt(1000000))
}
