package org.ythirion.refactoring.journey
package simplifying.method.calls

import java.time.LocalDate

case class Bill(amount: Double,
                invoicedDate: LocalDate,
                dueDate: LocalDate,
                paymentDate: Option[LocalDate] = None)
