package simplifying.method.calls

import java.time.LocalDate

final class AccountingService(bills: List[Bill]) {
  def findBillsInvoicedBetween(from: LocalDate, to: LocalDate): List[Bill] = {
    findBills(bill => Option(bill.invoicedDate), from, to)
  }

  private def findBills(
      dateSelector: Bill => Option[LocalDate],
      from: LocalDate,
      to: LocalDate
  ) = {
    bills.filter(bill => isInRange(dateSelector(bill), from, to))
  }

  private def isInRange(
      dateToCheck: Option[LocalDate],
      from: LocalDate,
      to: LocalDate
  ): Boolean = {
    dateToCheck.exists(date =>
      (date.isAfter(from) || date.isEqual(from)) && (date.isBefore(to) || date
        .isEqual(to))
    )
  }

  def findBillsDueBetween(from: LocalDate, to: LocalDate): List[Bill] = {
    findBills(bill => Option(bill.dueDate), from, to)
  }

  def findBillsPaidBetween(from: LocalDate, to: LocalDate): List[Bill] = {
    findBills(bill => bill.paymentDate, from, to)
  }
}
