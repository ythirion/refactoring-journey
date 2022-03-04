package composing.methods

import java.time.LocalDate

final case class Food(
    expirationDate: LocalDate,
    approvedForConsumption: Boolean,
    inspectorId: Option[Int]
) {
  lazy val isEdible: Boolean =
    isFresh && approvedForConsumption && hasBeenInspected
  val isFresh: Boolean = expirationDate.isAfter(LocalDate.now)
  val hasBeenInspected: Boolean = inspectorId.isDefined
}
