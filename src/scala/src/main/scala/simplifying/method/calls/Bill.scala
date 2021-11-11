package simplifying.method.calls

import java.time.LocalDate

final case class Bill(
    amount: Double,
    invoicedDate: LocalDate,
    dueDate: LocalDate,
    paymentDate: Option[LocalDate] = None
)
