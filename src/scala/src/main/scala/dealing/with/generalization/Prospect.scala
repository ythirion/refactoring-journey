package org.ythirion.refactoring.journey
package dealing.`with`.generalization

import java.time.LocalDate

case class Prospect(name: String,
                    email: String,
                    phone: String,
                    creationDate: LocalDate,
                    messages: List[String])