package simplifying.method.calls

import java.time.LocalDate

final class AccountingService(bills: List[Bill]) {
  def findBillsInvoicedBetween(period: Period): List[Bill] = {
    findBills(bill => Option(bill.invoicedDate), period)
  }

  def findBillsDueBetween(period: Period): List[Bill] = {
    findBills(bill => Option(bill.dueDate), period)
  }

  private def findBills(
      dateSelector: Bill => Option[LocalDate],
      period: Period
  ) = {
    bills.filter(bill => isInRange(dateSelector(bill), period))
  }

  private def isInRange(
      dateToCheck: Option[LocalDate],
      period: Period
  ): Boolean = {
    dateToCheck.exists(date =>
      (date.isAfter(period.from) || date.isEqual(period.from)) && (date
        .isBefore(period.to) || date.isEqual(period.to))
    )
  }

  def findBillsPaidBetween(period: Period): List[Bill] = {
    findBills(bill => bill.paymentDate, period)
  }
}
