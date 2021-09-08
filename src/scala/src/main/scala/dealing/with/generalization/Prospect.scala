package dealing.`with`.generalization

import java.time.LocalDate

final case class Prospect(
    name: String,
    email: String,
    phone: String,
    creationDate: LocalDate,
    messages: List[String]
)
