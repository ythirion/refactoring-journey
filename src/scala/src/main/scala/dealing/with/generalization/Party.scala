package org.ythirion.refactoring.journey
package dealing.`with`.generalization

import java.time.LocalDate

abstract class Party(val name: String,
                     val email: String,
                     val phone: String,
                     val creationDate: LocalDate,
                     val messages: List[String])