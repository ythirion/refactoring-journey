package org.ythirion.refactoring.journey
package dealing.`with`.generalization

import java.time.LocalDate

case class Customer(name: String,
                    email: String,
                    phone: String,
                    creationDate: LocalDate,
                    conversionDate: LocalDate,
                    messages: List[String])