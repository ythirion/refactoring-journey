package org.ythirion.refactoring.journey
package simplifying.method.calls

import org.scalatest.BeforeAndAfterEach
import org.scalatest.funsuite.AnyFunSuite

import java.util.UUID

class removeParameter extends AnyFunSuite with BeforeAndAfterEach {
  val TICKET_PRICE = 20
  val PRIZE_AMOUNT = 109_908_786
  var lottery: Lottery = null

  override def beforeEach(): Unit = {
    super.beforeEach()
    lottery = new Lottery()
  }

  test("lottery allows customer to purchase a ticket") {
    val ticketNumber = lottery.purchaseTicketForCustomer(UUID.randomUUID, "Mando")
    assert(ticketNumber.length == 6)
    assert(ticketNumber.matches("\\d+"))
  }

  test("lottery returns a Failure when draw without bought tickets") {
    val result = lottery.drawWinner(TICKET_PRICE, PRIZE_AMOUNT)
    assert(result.isEmpty)
  }
}
