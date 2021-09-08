package dealing.`with`.generalization

import java.time.LocalDate

final case class Customer(
    name: String,
    email: String,
    phone: String,
    creationDate: LocalDate,
    conversionDate: LocalDate,
    messages: List[String]
)
