package org.ythirion.refactoring.journey
package dealing.`with`.generalization

import java.time.LocalDate

class Prospect(name: String,
               email: String,
               phone: String,
               creationDate: LocalDate,
               messages: List[String]) extends Party(name, email, phone, creationDate, messages)