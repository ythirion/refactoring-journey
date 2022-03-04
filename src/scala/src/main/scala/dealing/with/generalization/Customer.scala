package dealing.`with`.generalization

import java.time.LocalDate

class Customer(
    name: String,
    email: String,
    phone: String,
    creationDate: LocalDate,
    val conversionDate: LocalDate,
    messages: List[String]
) extends Party(name, email, phone, creationDate, messages)
