package org.ythirion.refactoring.journey
package simplifying.method.calls

import org.scalatest.funsuite.AnyFunSuite

import java.time.LocalDate

class introduceParameterObject extends AnyFunSuite {
  private val accountingService = AccountingService(List(
    Bill(23_789, invoicedDate = LocalDate.of(1989, 1, 1), dueDate = LocalDate.of(1989, 2, 1), paymentDate = Some(LocalDate.of(2020, 12, 1))),
    Bill(67_987, invoicedDate = LocalDate.of(2020, 12, 1), dueDate = LocalDate.of(2021, 1, 1)),
    Bill(1256.99, invoicedDate = LocalDate.of(2020, 10, 9), dueDate = LocalDate.of(2020, 12, 1), paymentDate = Some(LocalDate.of(2020, 10, 10))),
    Bill(156_987, invoicedDate = LocalDate.of(2020, 10, 9), dueDate = LocalDate.of(2020, 12, 1), paymentDate = Some(LocalDate.of(2020, 12, 1))),
    Bill(34_900, invoicedDate = LocalDate.of(2020, 10, 9), dueDate = LocalDate.of(2021, 1, 1)),
    Bill(12_897, invoicedDate = LocalDate.of(2020, 1, 1), dueDate = LocalDate.of(2020, 2, 1), paymentDate = Some(LocalDate.of(2020, 1, 16))),
    Bill(98_765, invoicedDate = LocalDate.of(2020, 12, 31), dueDate = LocalDate.of(2021, 2, 1), paymentDate = Some(LocalDate.of(2021, 1, 2)))
  ))

  private def assertResult(bills: List[Bill], expectedSize: Int, expectedTotal: Double) = {
    assert(bills.size == expectedSize)
    assert(bills.map(_.amount).sum == expectedTotal)
  }

  test("find bills invoiced between 2 dates") {
    assertResult(
      accountingService.findBillsInvoicedBetween(Period(LocalDate.of(2020, 1, 1), LocalDate.of(2020, 12, 31))),
      expectedSize = 6,
      expectedTotal = 372792.99)
  }

  test("find bills due between 2 dates") {
    assertResult(
      accountingService.findBillsDueBetween(Period(LocalDate.of(1980, 10, 1), LocalDate.of(2019, 1, 31))),
      expectedSize = 1,
      expectedTotal = 23_789)
  }

  test("find bills paid between 2 dates") {
    assertResult(
      accountingService.findBillsPaidBetween(Period(LocalDate.of(1980, 10, 1), LocalDate.of(2020, 12, 31))),
      expectedSize = 4,
      expectedTotal = 194_929.99)
  }
}