package org.ythirion.refactoring.journey
package simplifying.method.calls

import java.util.UUID
import scala.collection.mutable
import scala.util.Random

object Lottery {
  private val RANDOM: Random = new Random(42)
}

class Lottery {
  final private val tickets = mutable.Map.empty[UUID, LotteryTicket]

  def purchaseTicketForCustomer(id: UUID): String = {
    val ticketNumber: String = generateTicketNumber()
    tickets(id) = LotteryTicket(ticketNumber, id)
    ticketNumber
  }

  def drawWinner(): Option[LotteryTicket] = {
    tickets.values match {
      case Nil => None
      case v => Random.shuffle(v).headOption
    }
  }

  private def generateTicketNumber(): String =
    String.format("%06d", Lottery.RANDOM.nextInt(1000000))
}